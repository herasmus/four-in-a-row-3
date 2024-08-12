package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinDetectorTest_HorizontalMatch {
    String horizontalMatchFourToWin_Middle[] =
            { "      ",
                    "XXOO  ",
                    "XOOX  ",
                    "XXOX  ",
                    "OXO   ",
                    "      ",
                    "OXOO  " };

    @Test
    public void horizontalMatchFourToWin_Middle() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        ColumnUtility columnUtility = new ColumnUtility(dimensions);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, columnUtility);
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_Middle);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertTrue(winDetector.hasHorizontalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }


    String horizontalMatchFourToWin_LowerLeft[] =
            { "X     ",
                    "XXXO  ",
                    "XOOX  ",
                    "XOXOO ",
                    "OXX   ",
                    "OXX   ",
                    "OXOO  " };

    @Test
    public void horizontalMatchFourToWin_LowerLeft() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        ColumnUtility columnUtility = new ColumnUtility(dimensions);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, columnUtility);
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_LowerLeft);

        assertFalse(winDetector.hasVerticalMatch(board[0]));
        assertTrue(winDetector.hasHorizontalMatch(board, 0));
        assertTrue(winDetector.hasWinner(board, 0));
    }

    String horizontalMatchFourToWin_UpperLeft[] =
            { "XOXOXO",
              "OOOXOO",
              "XOXXXO",
              "OXXOOO",
              "      ",
              "      ",
              "OXOOXO" };

    @Test
    public void horizontalMatchFourToWin_UpperLeft() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        ColumnUtility columnUtility = new ColumnUtility(dimensions);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, columnUtility);
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_UpperLeft);

        assertFalse(winDetector.hasVerticalMatch(board[2]));
        assertTrue(winDetector.hasHorizontalMatch(board, 2));
        assertTrue(winDetector.hasWinner(board, 2));
    }

    String horizontalMatchFourToWin_LowerRight[] =
            { "X     ",
                    "OXXO  ",
                    "XOOX  ",
                    "OOXOO ",
                    "OXX   ",
                    "O     ",
                    "OXOO  " };

    @Test
    public void horizontalMatchFourToWin_LowerRight() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        ColumnUtility columnUtility = new ColumnUtility(dimensions);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, columnUtility);
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_LowerRight);

        assertFalse(winDetector.hasVerticalMatch(board[5]));
        assertTrue(winDetector.hasHorizontalMatch(board, 5));
        assertTrue(winDetector.hasWinner(board, 5));
    }

    String horizontalMatchFourToWin_UpperRight[] =
            { "XOXOXO",
                    "      ",
                    "      ",
                    "OOOXOO",
                    "XOXXXO",
                    "OXXOOO",
                    "OXOOXO" };

    @Test
    public void horizontalMatchFourToWin_UpperRight() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        ColumnUtility columnUtility = new ColumnUtility(dimensions);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, columnUtility);
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_UpperRight);

        assertFalse(winDetector.hasVerticalMatch(board[3]));
        assertTrue(winDetector.hasHorizontalMatch(board, 3));
        assertTrue(winDetector.hasWinner(board, 3));
    }
}
