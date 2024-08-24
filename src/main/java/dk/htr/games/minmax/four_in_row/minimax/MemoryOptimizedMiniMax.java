package dk.htr.games.minmax.four_in_row.minimax;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.MoveExecuter;
import dk.htr.games.minmax.four_in_row.board.winning.WinDetector;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Component
@RequiredArgsConstructor
public class MemoryOptimizedMiniMax implements MiniMaxAlgorithm {
    static Logger logger = LoggerFactory.getLogger(MemoryOptimizedMiniMax.class);
    long nrOfBoardsEvaluated = 0;
    final private GameDimensions dimensions;
    final private BoardUtility boardUtility;
    final private WinDetector winDetector;
    final private MoveExecuter moveExecuter;
    private long initialBoard = -1L;

    @Override
    public long getNumberOfBoardsEvaluated() {
        return nrOfBoardsEvaluated;
    }

    private int maximize(long currentBoard) throws GameException {
        int best = -666_666;
        byte possibleMoves = boardUtility.getAvailableSlots(currentBoard);
        for(int move = 0; move < dimensions.getNrOfColumns(); move++) {
            if(((possibleMoves >> move)  & 0b0000_0001) == 0) {
                // Column full
                continue;
            }
            logger.trace("--> maximize AI placement: {}", move);
            // Make move
            long newBoard = moveExecuter.moveBlue(currentBoard, move);
            best = max(best, miniMax(newBoard, move, false));
            // We win - that is all we need
            if(best > 0 ) break;
        }
        return best;
    }

    private int minimize(long currentBoard) throws GameException {
        int best = 666_666;
        byte possibleMoves = boardUtility.getAvailableSlots(currentBoard);
        for(int move = 0; move < dimensions.getNrOfColumns(); move++) {
            if(((possibleMoves >> move)  & 0b0000_0001) == 0) {
                // Column full
                continue;
            }
            logger.trace("<-- minimize HUMAN move: {}", move);
            // Make move
            long newBoard = moveExecuter.moveRed(currentBoard, move);
            best = min(best, miniMax(newBoard, move, false));
            // We win - that is all we need
            if(best > 0 ) break;
        }
        return best;
    }

    private boolean gameOver(long board, int move) throws GameException {
        char[][] charBoard = boardUtility.convertToCharMatrix(board);
        return (board != initialBoard) && winDetector.hasWinner(charBoard, move);
    }

    @Override
    public int miniMax(long board, int move, boolean isMaximising) throws GameException {
        nrOfBoardsEvaluated++;
        if (logger.isTraceEnabled()) {
            logger.trace("Boards evaluated so far: {}", nrOfBoardsEvaluated);
        } else {
            if (nrOfBoardsEvaluated % 10000 == 0) {
                logger.debug("Boards evaluated so far: {}", nrOfBoardsEvaluated);
            }
        }

        // if state is terminal, then return score (Leaf node)
        if(gameOver(board, move)) {
            if (isMaximising) {
                return 1;
            } else {
                return -1;
            }
        }

        // AIPlayer (maximising player)
        if (isMaximising) {
            logger.trace("AI Player - maximizing)");
            return maximize(board);
        } else {
            logger.trace("Human player - minimizing)");
            return minimize(board);
        }
    }

    public int run() throws GameException {
        initialBoard = boardUtility.createInitialBoard();
        return miniMax(initialBoard, -1, true);
    }
}
