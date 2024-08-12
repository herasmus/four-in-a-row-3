package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinDetectorTest_VerticalMatch {
    String verticalMatchFourToWin_Middle[] =
            { "      ",
                    "XXXO  ",
                    "XOOX  ",
                    "XOOOO ",
                    "OXX   ",
                    "OXX   ",
                    "OXOO  " };

    @Test
    public void verticalMatchFourToWin_Middle() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_Middle);

        assertTrue(winDetector.hasVerticalMatch(board[3]));
        assertTrue(winDetector.hasWinner(board, 3));
    }

    String verticalMatchFourToWin_LowerLeft[] =
            { "OOOO  ",
                    "XXXO  ",
                    "XOOX  ",
                    "OXXX  ",
                    "OXXX  ",
                    "O     ",
                    "OXOO  " };

    @Test
    public void verticalMatchFourToWin_LowerLeft() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_LowerLeft);

        assertTrue(winDetector.hasVerticalMatch(board[0]));
        assertTrue(winDetector.hasWinner(board, 0));
    }

    String verticalMatchFourToWin_UpperLeft[] =
            { "XXOOOO",
                    "XXXO  ",
                    "XOOX  ",
                    "OXXX  ",
                    "OXXX  ",
                    "O     ",
                    "OXOO  " };

    @Test
    public void verticalMatchFourToWin_UpperLeft() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_UpperLeft);

        assertTrue(winDetector.hasVerticalMatch(board[0]));
        assertTrue(winDetector.hasWinner(board, 0));
    }

    String verticalMatchFourToWin_LowerRight[] =
            { "XXOXOO",
                    "XXXO  ",
                    "XOOX  ",
                    "OXXX  ",
                    "OXXX  ",
                    "O     ",
                    "XXXX  " };

    @Test
    public void verticalMatchFourToWin_LowerRight() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_LowerRight);

        assertTrue(winDetector.hasVerticalMatch(board[6]));
        assertTrue(winDetector.hasWinner(board, 6));
    }

    String verticalMatchFourToWin_UpperRight[] =
            { "      ",
                    "XXXO  ",
                    "XOOX  ",
                    "OXXX  ",
                    "OXX   ",
                    "      ",
                    "OXOOOO" };

    @Test
    public void verticalMatchFourToWin_UpperRight() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_UpperRight);

        assertTrue(winDetector.hasVerticalMatch(board[6]));
        assertTrue(winDetector.hasWinner(board, 6));
    }
}
