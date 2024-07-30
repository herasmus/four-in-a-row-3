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
@RequiredArgsConstructor
public class WinDetectorImpl implements WinDetector {
    private static Logger logger = LoggerFactory.getLogger(WinDetectorImpl.class);

    private final GameDimensions dimensions;

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
        for(int colNr = 0; colNr <= (dimensions.getNrOfColumns() - dimensions.getLengthToWin()); colNr++) {
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
        logger.trace("Win detection - Lower Left to Upper Right:");
        logger.trace("------------------------------------------");
        char[] column = board[move];
        int numberOfDiscs = ColumnUtility.getNumberDiscs(column);
        char thisMoveDiscColour = column[numberOfDiscs - 1];
        char[] currentColumn;
        /*
        for(int colNr = 0; colNr <= (dimensions.getNrOfColumns() - dimensions.getLengthToWin()); colNr++) {
            currentColumn = board[colNr];
            int nrOfDiscsCurrentColumn = ColumnUtility.getNumberDiscs(column);
            if(nrOfDiscsCurrentColumn == 0) break;
            for(int rowNr = 0; colNr < dimensions.getNrOfColumns() - dimensions.getLengthToWin(); colNr++) {
            if(column[i] != thisMoveDiscColour) {
                return false;
            }


        }*/
        return false;
    }

    protected boolean hasDiagonalMatch(char[][] board, int move) throws GameException {
        if(hasDiagonalMatchUpperLeftToLowerRight(board, move)) {
            return true;
        }
        return hasDiagonalMatchLowerLeftToUpperRight(board, move);
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
