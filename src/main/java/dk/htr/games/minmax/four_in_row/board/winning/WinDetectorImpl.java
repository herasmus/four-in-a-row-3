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
    private char thisMoveDiscColour;
    private int numberOfDiscs;

    @Override
    public boolean hasWinner(char[][] board, int move) throws GameException {
        char[] column = board[move];
        numberOfDiscs = columnUtility.getNumberDiscs(column);
        thisMoveDiscColour = column[numberOfDiscs - 1];
        logger.debug("");
        logger.debug("             Win detection ");
        logger.debug("------------------------------------------");
        logger.debug("Active Player colour:      {}", thisMoveDiscColour);

        if(logger.isDebugEnabled()) {
            boardStateLogger.logBoardStateDebug(board, logger);
            logger.debug("");
        }
        if(hasVerticalMatch(board[move])) {
            logger.debug("### Match ###");
            return true;
        }
        if(hasHorizontalMatch(board, move)) {
            logger.debug("### Match ###");
            return true;
        }
        if(hasDiagonalMatch(board, move)) {
            logger.debug("### Match ###");
            return true;
        }
        return false;
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
        logger.debug("Vertical:");
        logger.debug("---------");
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
        logger.debug("Horizontal:");
        logger.debug("----------:");
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
        logger.debug("Upper Left to Left Right:");
        logger.debug("-------------------------");

        for (int colNr = 0; colNr <= (dimensions.getNrOfColumns() - dimensions.getLengthToWin()); colNr++) {
            logger.trace("Column nr:                 {}", colNr);
            logger.trace("Column:                    '" + (new String(board[colNr])) + "'");
            int startRow = dimensions.getNrOfRows() - 1;
            int numberOfStartRowPositions = dimensions.getNrOfColumns() - dimensions.getLengthToWin();
            outer:
            for (int rowNr = startRow; rowNr >= numberOfStartRowPositions; rowNr--) {
                for (int i = 0; i < dimensions.getLengthToWin(); i++) {
                    char currentDiscColour = board[colNr + i][rowNr - i];
                    logger.trace("Position: {}, {}     Colour: '{}'", colNr + i, rowNr - i, currentDiscColour);
                    if (currentDiscColour != thisMoveDiscColour) {
                        logger.trace("--> No Match <--\n");
                        continue outer;
                    }
                }
                return true;
            }
        }
        return false;
    }

    protected boolean hasDiagonalMatchLowerLeftToUpperRight(char[][] board, int move) {
        logger.debug("Lower Left to Upper Right:");
        logger.debug("- ------------------------");

        int numberOfStartRowPositions = dimensions.getNrOfColumns() - dimensions.getLengthToWin();
        for (int colNr = 0; colNr <= numberOfStartRowPositions; colNr++) {
            logger.trace("Column nr:                 {}", colNr);
            logger.trace("Column:                    '{}'", new String(board[colNr]));
            outer:
            for (int rowNr = 0; rowNr <= (dimensions.getNrOfRows() - dimensions.getLengthToWin()); rowNr++) {
                for (int i = 0; i < dimensions.getLengthToWin(); i++) {
                    char currentDiscColour = board[colNr + i][rowNr + i];
                    logger.trace("Position: {}, {}     Colour: '{}'", colNr + i, rowNr + i, currentDiscColour);
                    if (currentDiscColour != thisMoveDiscColour) {
                        logger.trace("--> No Match <--\n");
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
