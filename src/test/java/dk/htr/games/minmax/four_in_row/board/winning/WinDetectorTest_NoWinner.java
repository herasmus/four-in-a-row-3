package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class WinDetectorTest_NoWinner {
    String noMatchFourToWin[] =
            { "      ",
              "XOXO  ",
              "OOOX  ",
              "X     ",
              "XXX   ",
              "OXX   ",
              "OXXO  " };

    @Test
    public void noWinnerFourToWin() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        ColumnUtility columnUtility = new ColumnUtility(dimensions);
        WinDetector winDetector = new WinDetectorImpl(dimensions, columnUtility, null);
        char[][] board = BoardCreator.createBoard(noMatchFourToWin);
        assertFalse(winDetector.hasWinner(board, 1));
        assertFalse(winDetector.hasWinner(board, 2));
        assertFalse(winDetector.hasWinner(board, 3));
        assertFalse(winDetector.hasWinner(board, 4));
        assertFalse(winDetector.hasWinner(board, 5));
    }
}
