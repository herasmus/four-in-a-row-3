package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinDetectorTest {
    final static GameDimensions gameDim3x4x4 = new GameDimensions(3, 4, 4);

    String verticalMatchFourToWin_1[] =
            { "      ",
              "XXXO  ",
              "XOOX  ",
              "XOOOO ",
              "OXX   ",
              "OXX   ",
              "OXOO  " };

    @Test
    public void verticalMatchFourToWin_1() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_1);

        assertTrue(winDetector.hasVerticalMatch(board[3]));
        assertTrue(winDetector.hasWinner(board, 3));
    }

    String verticalMatchFourToWin_2[] =
            { "      ",
              "XXXO  ",
              "XOOX  ",
              "OXXX  ",
              "XXXX  ",
              "O     ",
              "OXOO  " };

    @Test
    public void verticalMatchFourToWin_2() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_2);

        assertTrue(winDetector.hasVerticalMatch(board[4]));
        assertTrue(winDetector.hasWinner(board, 4));
    }

    String verticalMatchFourToWin_3[] =
            { "      ",
              "XXXO  ",
              "XOOX  ",
              "OXXX  ",
              "OXX   ",
              "      ",
              "OXOOOO" };

    @Test
    public void verticalMatchFourToWin_3() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_3);

        assertTrue(winDetector.hasVerticalMatch(board[6]));
        assertTrue(winDetector.hasWinner(board, 6));
    }

    String horizontalMatchFourToWin_LowerRight[] =
            { "X     ",
              "XXXO  ",
              "XOOX  ",
              "XOXOO ",
              "OXX   ",
              "OXX   ",
              "OXOO  " };

    @Test
    public void horizontalMatchFourToWin_LowerRight() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_LowerRight);

        assertFalse(winDetector.hasVerticalMatch(board[0]));
        assertTrue(winDetector.hasHorizontalMatch(board, 0));
        assertTrue(winDetector.hasWinner(board, 0));
    }


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
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_Middle);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertTrue(winDetector.hasHorizontalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }

    String horizontalMatchFourToWin_3[] =
            { "      ",
              "XOXOXO",
              "OOOXOO",
              "XOXXXO",
              "OXXOOO",
              "      ",
              "OXOOXO" };

    @Test
    public void horizontalMatchFourToWin_3() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_3);

        assertFalse(winDetector.hasVerticalMatch(board[2]));
        assertTrue(winDetector.hasHorizontalMatch(board, 2));
        assertTrue(winDetector.hasWinner(board, 2));
    }

    String diagonalMatchUpperLeftToLowerRight_1[] =
            { "OOXO  ",
              "XXOO  ",
              "XOOX  ",
              "OOXOX ",
              "      ",
              "      ",
              "XOOX  " };

    @Test
    public void diagonalMatchUpperLeftToLowerRight_1() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftToLowerRight_1);

        assertFalse(winDetector.hasVerticalMatch(board[2]));
        assertFalse(winDetector.hasHorizontalMatch(board, 2));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, 2));
        assertTrue(winDetector.hasWinner(board, 2));
    }

    String diagonalMatchUpperLeftToLowerRight_2[] =
            { "      ",
                    "XXOO  ",
                    "OOOX  ",
                    "XXOX  ",
                    "XXXO  ",
                    "OX    ",
                    "X     " };

    @Test
    public void diagonalMatchUpperLeftToLowerRight_2() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftToLowerRight_2);

        assertFalse(winDetector.hasVerticalMatch(board[6]));
        assertFalse(winDetector.hasHorizontalMatch(board, 6));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, 6));
        assertTrue(winDetector.hasDiagonalMatch(board, 6));
        assertTrue(winDetector.hasWinner(board, 6));
    }

    String hasDiagonalMatchLowerLeftToUpperRight_1[] =
            { "      ",
              "X     ",
              "OXOO  ",
              "XOX   ",
              "OOOX  ",
              "      ",
              "OXOOXO" };



    @Test
    public void hasDiagonalMatchLowerLeftToUpperRight_1() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(hasDiagonalMatchLowerLeftToUpperRight_1);

        assertFalse(winDetector.hasVerticalMatch(board[3]));
        assertFalse(winDetector.hasHorizontalMatch(board, 3));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 3));
        assertTrue(winDetector.hasDiagonalMatch(board, 3));
        assertTrue(winDetector.hasWinner(board, 3));
    }

    String hasDiagonalMatchLowerLeftToUpperRight_2[] =
            { "      ",
              "XOXOXO",
              "      ",
              "XXOO  ",
              "OOXO  ",
              "OOXOO ",
              "OXOXXO" };

    @Test
    public void hasDiagonalMatchLowerLeftToUpperRight_2() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(hasDiagonalMatchLowerLeftToUpperRight_2);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertFalse(winDetector.hasHorizontalMatch(board, 4));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }

    String noMatchFourToWin[] =
            { "      ",
              "XOXO  ",
              "OOOX  ",
              "XXX   ",
              "OXX   ",
              "OXXO  " };

    @Test
    public void noWinnerFourToWin() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetector winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(noMatchFourToWin);
        assertFalse(winDetector.hasWinner(board, 1));
        assertFalse(winDetector.hasWinner(board, 2));
        assertFalse(winDetector.hasWinner(board, 3));
        assertFalse(winDetector.hasWinner(board, 4));
        assertFalse(winDetector.hasWinner(board, 5));
    }
}
