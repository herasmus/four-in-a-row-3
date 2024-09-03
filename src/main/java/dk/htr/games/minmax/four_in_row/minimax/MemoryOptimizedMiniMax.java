package dk.htr.games.minmax.four_in_row.minimax;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.MoveExecuter;
import dk.htr.games.minmax.four_in_row.board.winning.WinDetector;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.config.WinningBoardSettings;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Component
@RequiredArgsConstructor
public class MemoryOptimizedMiniMax implements MiniMaxAlgorithm {
    static Logger logger = LoggerFactory.getLogger(MemoryOptimizedMiniMax.class);
    long nrOfBoardsEvaluated = 0;
    final private GameDimensions gameDimensions;
    final private WinningBoardSettings winningBoardSettings;
    final private BoardUtility boardUtility;
    final private WinDetector winDetector;
    final private MoveExecuter moveExecuter;
    private int initialMove = -1;
    private long numberOfWinningBoardsAI;
    private BufferedWriter bufferedWriter;

    @Override
    public long getNumberOfBoardsEvaluated() {
        return nrOfBoardsEvaluated;
    }

    public long getNumberOfWinningBoardsAI() {
        return numberOfWinningBoardsAI;
    }

    public void closeFile() throws IOException {
        if(winningBoardSettings.isSaveWinningBoards()) {
            bufferedWriter.close();
        }
    }

    private int maximize(long currentBoard) throws GameException, IOException {
        int best = -666_666;
        byte possibleMoves = boardUtility.getAvailableSlots(currentBoard);
        for(int move = 0; move < gameDimensions.getNrOfColumns(); move++) {
            if(((possibleMoves >> move)  & 0b0000_0001) == 0) {
                // Column full
                continue;
            }
//            logger.trace("--> maximize AI placement: {}", move);
            // Make move
            //long newBoard = moveExecuter.moveBlue(currentBoard, move);
            best = max(best, miniMax(moveExecuter.moveBlue(currentBoard, move), move, false));
            // We win - that is all we need
            if(best > 0 ) break;
        }
        return best;
    }

    private int minimize(long currentBoard) throws GameException, IOException {
        int best = 666_666;
        byte possibleMoves = boardUtility.getAvailableSlots(currentBoard);
        for(int move = 0; move < gameDimensions.getNrOfColumns(); move++) {
            if(((possibleMoves >> move)  & 0b0000_0001) == 0) {
                // Column full
                continue;
            }
//            logger.trace("<-- minimize HUMAN move: {}", move);
            // Make move
//            long newBoard = moveExecuter.moveRed(currentBoard, move);
            best = min(best, miniMax(moveExecuter.moveRed(currentBoard, move), move, true));
            // We win - that is all we need
            if(best < 0 ) break;
        }
        return best;
    }

    @Override
    public int miniMax(long board, int move, boolean isMaximising) throws GameException, IOException {
        nrOfBoardsEvaluated++;
/*        if (logger.isTraceEnabled()) {
            logger.trace("Boards evaluated so far: {}", nrOfBoardsEvaluated);
        } else {
            if (nrOfBoardsEvaluated % 100000 == 0) {
                logger.info("Boards evaluated so far: {}", nrOfBoardsEvaluated);
            }
        }*/

        if(move != initialMove) {
            int evalutionResult = winDetector.winner(board, move);
            if (evalutionResult != 0) {
                if(winningBoardSettings.isSaveWinningBoards()) {
                    if(numberOfWinningBoardsAI % 10000 == 0) {
                        System.out.println("Number of winningboards: " + numberOfWinningBoardsAI);
                    }
                    bufferedWriter.write(Long.toString(board));
                    bufferedWriter.newLine();
                }
                if (evalutionResult > 0) {

                    numberOfWinningBoardsAI++;
                    // AI Wins
                    return 1;
                } else {
                    // Player Wins
                    return -1;
                }
            }
        } else {
            if(winningBoardSettings.isSaveWinningBoards()) {
                var fw = new FileWriter(winningBoardSettings.getWinningBoardsFilePath(), false);
                bufferedWriter = new BufferedWriter(new BufferedWriter(fw));
            }
        }

        /*
        if(move != initialMove) {
            char[][] charBoard = boardUtility.convertToCharMatrix(board);
            int evalutionResult = winDetector.winner(charBoard, move);
            if(evalutionResult != 0) {
                if(evalutionResult > 0) {
                    numberOfWinningBoardsAI++;
                    // AI Wins
                    return 1;
                } else {
                    // Player Wins
                    return -1;
                }
            }
        }*/

        // AIPlayer (maximising player)
        if (isMaximising) {
    //        logger.debug("# AI Player - maximizing)");
            return maximize(board);
        } else {
      //      logger.debug("# Human player - minimizing)");
            return minimize(board);
        }
    }

    public int run() throws GameException, IOException {
        var initialBoard = boardUtility.createInitialBoard();
        long startTime = System.nanoTime();
        var result = miniMax(initialBoard, -1, true);

        if(winningBoardSettings.isSaveWinningBoards()) {
            bufferedWriter.close();
        }

        long endTime = System.nanoTime();
        // Convert to milliseconds if needed
        double elapsedTimeInMillis = endTime / 1_000_000.0;

        // Print the execution time
        logger.error("Elapsed time in nanoseconds: " + endTime);
        logger.error("Elapsed time in milliseconds: " + elapsedTimeInMillis);


        return result;
    }
}
