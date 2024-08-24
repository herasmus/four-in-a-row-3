package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/*
 *  The logic of these methods can be hard to understand - even for the author
 *
 *  So comprehensive testing is needed
 */
@Component
@RequiredArgsConstructor
public class WinDetectorImpl implements WinDetector {
    private static final Logger logger = LoggerFactory.getLogger(WinDetectorImpl.class);
    private final GameDimensions dimensions;
    private final ColumnUtility columnUtility;
    private final BoardStateLogger boardStateLogger;

    @Override
    public boolean hasWinner(char[][] board, int move) throws GameException {
        if(logger.isTraceEnabled()) {
            boardStateLogger.logBoardStateTrace(board);
        }
        if (hasVerticalMatch(board[move])) {
            return true;
        }
        if (hasHorizontalMatch(board, move)) {
            return true;
        }
        return hasDiagonalMatch(board, move);
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
        int numberOfDiscs = columnUtility.getNumberDiscs(column);
        // Pretty straight forward
        if (numberOfDiscs >= dimensions.getLengthToWin()) {
            char thisMoveDiscColour = column[numberOfDiscs - 1];
            int startingDiscPos = numberOfDiscs - dimensions.getLengthToWin();
            for (int i = startingDiscPos; i < (startingDiscPos + dimensions.getLengthToWin()); i++) {
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
        char[] column = board[move];
        int numberOfDiscs = columnUtility.getNumberDiscs(column);
        char thisMoveDiscColour = column[numberOfDiscs - 1];

        int numberInARow = 0;
        for (int colNr = 0; colNr < dimensions.getNrOfColumns(); colNr++) {
            if (board[colNr][numberOfDiscs - 1] == thisMoveDiscColour) {
                numberInARow++;
            } else {
                numberInARow = 0;
            }
            if (numberInARow == dimensions.getLengthToWin()) {
                return true;
            }
        }
        return false;
    }

    protected boolean hasDiagonalMatchUpperLeftToLowerRight(char[][] board, int move) {
        logger.warn("Win detection - Upper Left to Left Right:");
        logger.warn("-----------------------------------------");
        char[] column = board[move];
        int numberOfDiscs = columnUtility.getNumberDiscs(column);
        char thisMoveDiscColour = column[numberOfDiscs - 1];
        logger.warn("Active Player colour:      {}", thisMoveDiscColour);

        for (int colNr = 0; colNr <= (dimensions.getNrOfColumns() - dimensions.getLengthToWin()); colNr++) {
            logger.warn("Column nr:                 " + colNr);
            logger.warn("Column:                    '" + (new String(board[colNr])) + "'");
            int startRow = dimensions.getNrOfRows() - 1;
            int numberOfStartRowPositions = dimensions.getNrOfColumns() - dimensions.getLengthToWin();
            outer:
            for (int rowNr = startRow; rowNr >= numberOfStartRowPositions; rowNr--) {
                for (int i = 0; i < dimensions.getLengthToWin(); i++) {
                    char currentDiscColour = board[colNr + i][rowNr - i];
                    logger.warn("Position: {}, {}     Colour: '{}'", colNr + i, rowNr - i, currentDiscColour);
                    if (currentDiscColour != thisMoveDiscColour) {
                        logger.warn("--> No Match <--\n");
                        continue outer;
                    }
                }
                logger.warn("****** --> Match <-- ******\n");
                return true;
            }
        }
        return false;
    }

    protected boolean hasDiagonalMatchLowerLeftToUpperRight(char[][] board, int move) {
        logger.warn("Win detection - Lower Left to Upper Right:");
        logger.warn("------------------------------------------");
        char[] column = board[move];
        int numberOfDiscs = columnUtility.getNumberDiscs(column);
        char thisMoveDiscColour = column[numberOfDiscs - 1];
        logger.warn("Active Player colour:      {}", thisMoveDiscColour);

        int numberOfStartRowPositions = dimensions.getNrOfColumns() - dimensions.getLengthToWin();
        for (int colNr = 0; colNr <= numberOfStartRowPositions; colNr++) {
            logger.warn("Column nr:                 {}", colNr);
            logger.warn("Column:                    '{}'", new String(board[colNr]));
            outer:
            for (int rowNr = 0; rowNr <= (dimensions.getNrOfRows() - dimensions.getLengthToWin()); rowNr++) {
                for (int i = 0; i < dimensions.getLengthToWin(); i++) {
                    char currentDiscColour = board[colNr + i][rowNr + i];
                    logger.warn("Position: {}, {}     Colour: '{}'", colNr + i, rowNr + i, currentDiscColour);
                    if (currentDiscColour != thisMoveDiscColour) {
                        logger.warn("--> No Match <--\n");
                        continue outer;
                    }
                }
                logger.warn("****** --> Match <-- ******\n");
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
