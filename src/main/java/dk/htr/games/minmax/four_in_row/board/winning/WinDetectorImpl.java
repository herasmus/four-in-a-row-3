package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 *  The logic of these methods can be hard to understand - even for the author
 *
 *  So comprehensive testing is needed
 */
public class WinDetectorImpl implements WinDetector {
    private static Logger logger = LoggerFactory.getLogger(WinDetectorImpl.class);
    private final GameDimensions dimensions;

    /*
     * Use the same object instead of creating a new - to save memory
     */
    final int[][] winningRow;
    final WinResult lastResult;

    public WinDetectorImpl(GameDimensions dimensions) {
        this.dimensions = dimensions;
        winningRow      = new int[dimensions.getLengthToWin()][2];
        lastResult      =  new WinResult(false, -1, winningRow);
    }

    @Override
    public boolean hasWinner(char[][] board, int move) throws GameException {
        if(hasVerticalMatch(board[move])) {
            return true;
        }
        if(hasHorizontalMatch(board, move)) {
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
    protected boolean hasVerticalMatch(char[] column) throws GameException {
        int numberOfDiscs = ColumnUtility.getNumberDiscs(column);
        // Pretty straight forward
        if(numberOfDiscs >= dimensions.getLengthToWin()) {
            char thisMoveDiscColour = column[numberOfDiscs - 1];
            int startingDiscPos = numberOfDiscs - dimensions.getLengthToWin();
            for(int i = startingDiscPos; i < (startingDiscPos + dimensions.getLengthToWin()); i++) {
                if(column[i] != thisMoveDiscColour) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    protected boolean hasHorizontalMatch(char[][] board, int move) throws GameException {
        char[] column = board[move];
        int numberOfDiscs = ColumnUtility.getNumberDiscs(column);
        char thisMoveDiscColour = column[numberOfDiscs - 1];

        int numberInARow = 0;
        for(int colNr = 0; colNr < dimensions.getNrOfColumns(); colNr++) {
            char[] col = board[colNr];
            char ch = board[colNr][numberOfDiscs-1];
            if(board[colNr][numberOfDiscs-1] == thisMoveDiscColour) {
                numberInARow++;
            } else {
                numberInARow = 0;
            }
            if(numberInARow == dimensions.getLengthToWin()) {
                return true;
            }
        }
        return false;
    }

    protected boolean hasDiagonalMatchUpperLeftToLowerRight(char[][] board, int move) {
        return false;
    }

    protected boolean hasDiagonalMatchLowerLeftToUpperRight(char[][] board, int move) throws GameException {
        logger.warn("Win detection - Lower Left to Upper Right:");
        logger.warn("------------------------------------------");
        char[] column = board[move];
        int numberOfDiscs = ColumnUtility.getNumberDiscs(column);
        char thisMoveDiscColour = column[numberOfDiscs - 1];
        logger.warn("Active Player colour:      " + thisMoveDiscColour);

        outerloop:
        for(int colNr = 0; colNr < (dimensions.getNrOfColumns() - dimensions.getLengthToWin()); colNr++) {
            logger.warn("Column nr:                 " + colNr);
            logger.warn("Column:                    '" + (new String(board[colNr])) + "'");
            for(int rowNr = 0; rowNr <= (dimensions.getNrOfRows() - dimensions.getLengthToWin()); rowNr++) {
                for(int i = 0; i < dimensions.getLengthToWin(); i++) {
                    char currentDiscColour = board[colNr + i][rowNr + i];
                    logger.warn("Position: " + (colNr + i) + ", " + (rowNr + i) + "     Colour: " + "'" + currentDiscColour + "'");
                    if(currentDiscColour != thisMoveDiscColour) {
                        logger.warn("--> No Match <--\n");
                        continue outerloop;
                    }
                }
                logger.warn("****** --> Match <-- ******\n");
                return true;
            }
        }
        return false;
    }

    protected boolean hasDiagonalMatch(char[][] board, int move) throws GameException {
        if(hasDiagonalMatchLowerLeftToUpperRight(board, move)) {
            return true;
        }
        return hasDiagonalMatchUpperLeftToLowerRight(board, move);
    }

  /*
    private WinResult getDiagonalResult(char[][] board) {
    }

    private WinResult getHorizontalResult(char[][] board) {
        return null;
    }

    private WinResult getVerticalResult(char[] column, move ) {
        return null;
    }
*/


/*
    @Override
    public WinResult getWinResult(char[][] board, int move, boolean blueDisc) throws GameException {
        WinResult winResult = getVerticalResult();
        if(winResult == null) {
            winResult = getHorizontalResult(board);
        } else {
            return winResult;
        }
        if(winResult == null) {
            winResult = getDiagonalResult(board);
        }
        if(winResult == null) {
            return new WinResult(false, move, null);
        } else {
            return  winResult;
        }
    }

    private WinResult getDiagonalResult(char[][] board) {
    }

    private WinResult getHorizontalResult(char[][] board) {
        return null;
    }

    private WinResult getVerticalResult(char[] column, move ) {
        return null;
    }*/
}
