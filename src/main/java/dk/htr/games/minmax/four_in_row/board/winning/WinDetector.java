package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;

/**
 * Created with speed in mind - don't want to create WinResult unless we have a winner
 */
public interface WinDetector {
    boolean hasWinner(char[][] board, int move) throws GameException;
//    WinResult getLastWinResult(char[][] board, int move, boolean blueDisc) throws GameException;
}
