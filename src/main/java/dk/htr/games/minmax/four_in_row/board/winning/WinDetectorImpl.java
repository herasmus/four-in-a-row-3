package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.config.WinningBoardSettings;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
 *  The logic of these methods can be hard to understand - even for the author
 *
 *  So comprehensive testing is needed
 */
@Getter
@Setter
@Component
public class WinDetectorImpl implements WinDetector {
    private static final Logger logger = LoggerFactory.getLogger(WinDetectorImpl.class);
    @Autowired
    private GameDimensions gameDimensions;
//    @Autowired
//    private WinningBoardSettings winningBoardSettings;
    @Autowired
    private ColumnUtility columnUtility;
    @Autowired
    private BoardStateLogger boardStateLogger;
    @Autowired
    private BoardUtility boardUtility;

    protected char thisMoveDiscColour;
    protected int numberOfDiscs;
//    private BufferedWriter bufferedWriter;

//    public WinDetectorImpl() throws IOException {
  /*      if(winningBoardSettings.isSaveWinningBoards()) {
            var fw = new FileWriter(winningBoardSettings.getWinningBoardsFilePath(), false);
            bufferedWriter = new BufferedWriter(new BufferedWriter(fw));
        }*/
  //  }


    @Override
    public char winner(long board, int move) throws GameException {
        char[][] charBoard = boardUtility.convertToCharMatrix(board);
        return winner(charBoard, move);
    }

    private char winner(char[][] board, int move) throws GameException {
        char[] column = board[move];
        numberOfDiscs = columnUtility.getNumberDiscs(column);
        thisMoveDiscColour = column[numberOfDiscs - 1];
     //   logger.debug("");
//        logger.debug("             Win detection ");
  //      logger.debug("------------------------------------------");
   //     logger.debug("Active Player colour:      {}", thisMoveDiscColour);

     //   if(logger.isDebugEnabled()) {
     //       boardStateLogger.logBoardStateDebug(board, logger);
     //       logger.debug("");
       // }
        if(hasVerticalMatch(board[move])) {
       //     logger.debug("### Match ###");
            return thisMoveDiscColour;
        }
        if(hasHorizontalMatch(board, move)) {
       //     logger.debug("### Match ###");
            return thisMoveDiscColour;
        }
        if(hasDiagonalMatch(board, move)) {
       //     logger.debug("### Match ###");
            return thisMoveDiscColour;
        }
        return 0;
    }

    /*
     * 7 x 6 with 4 to win example
     *
     *  |
     *  |
     *
     *
     *
     */
    protected boolean hasVerticalMatch(char[] column) {
//        logger.debug("Vertical:");
  //      logger.debug("---------");
        // Pretty straight forward
        if (numberOfDiscs >= gameDimensions.getLengthToWin()) {
            char thisMoveDiscColour = column[numberOfDiscs - 1];
            int startingDiscPos = numberOfDiscs - gameDimensions.getLengthToWin();
            for (int i = startingDiscPos; i < (startingDiscPos + gameDimensions.getLengthToWin()); i++) {
                if (column[i] != thisMoveDiscColour) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    protected boolean hasHorizontalMatch(char[][] board, int move) {
    //    logger.debug("Horizontal:");
   //     logger.debug("----------:");
        int numberInARow = 0;
        for (int colNr = 0; colNr < gameDimensions.getNrOfColumns(); colNr++) {
            if (board[colNr][numberOfDiscs - 1] == thisMoveDiscColour) {
                numberInARow++;
            } else {
                numberInARow = 0;
            }
            if (numberInARow == gameDimensions.getLengthToWin()) {
                return true;
            }
        }
        return false;
    }

    protected boolean hasDiagonalMatchUpperLeftToLowerRight(char[][] board, int move) {
     //   logger.debug("Upper Left to Lower Right:");
     //   logger.debug("--------------------------");

        int numberOfStartRowPositions = gameDimensions.getNrOfColumns() - gameDimensions.getLengthToWin();
        for (int colNr = 0; colNr <= numberOfStartRowPositions; colNr++) {
       //     logger.trace("Column nr:                 {}", colNr);
      //      logger.trace("Column:                    '" + (new String(board[colNr])) + "'");
            int startRow = gameDimensions.getNrOfRows() - 1;
            outer:
            for (int rowNr = startRow; rowNr >= (gameDimensions.getLengthToWin() - 1); rowNr--) {
                for (int i = 0; i < gameDimensions.getLengthToWin(); i++) {
        //            logger.trace("Position: {}, {}", colNr + i, rowNr - i);
                    char currentDiscColour = board[colNr + i][rowNr - i];
          //          logger.trace("Colour:  '{}'", currentDiscColour);
                    if (currentDiscColour != thisMoveDiscColour) {
            //            logger.trace("--> No Match <--\n");
                        continue outer;
                    }
                }
                return true;
            }
        }
        return false;
    }

    protected boolean hasDiagonalMatchLowerLeftToUpperRight(char[][] board, int move) {
//        logger.debug("Lower Left to Upper Right:");
  //      logger.debug("--------------------------");

        int numberOfStartRowPositions = gameDimensions.getNrOfColumns() - gameDimensions.getLengthToWin();
        for (int colNr = 0; colNr <= numberOfStartRowPositions; colNr++) {
    //        logger.trace("Column nr:                 {}", colNr);
      //      logger.trace("Column:                    '{}'", new String(board[colNr]));
            outer:
            for (int rowNr = 0; rowNr <= (gameDimensions.getNrOfRows() - gameDimensions.getLengthToWin()); rowNr++) {
                for (int i = 0; i < gameDimensions.getLengthToWin(); i++) {
        //            logger.trace("Position: {}, {}", colNr + i, rowNr + i);
                    char currentDiscColour = board[colNr + i][rowNr + i];
          //          logger.trace("Colour:  '{}'", currentDiscColour);
                    if (currentDiscColour != thisMoveDiscColour) {
            //            logger.trace("--> No Match <--\n");
                        continue outer;
                    }
                }
                return true;
            }
        }
        return false;
    }

    protected boolean hasDiagonalMatch(char[][] board, int move) throws GameException {
        if (hasDiagonalMatchLowerLeftToUpperRight(board, move)) {
            return true;
        }
        return hasDiagonalMatchUpperLeftToLowerRight(board, move);
    }
}
