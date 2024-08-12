package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class WinDetectorTest_DiagonalMatch_LowerLeftToUpperRight {
    Logger logger = LoggerFactory.getLogger(WinDetectorTest_DiagonalMatch_LowerLeftToUpperRight.class);

    String diagonalMatchLowerLeftUpperRight_Middle[] =
            { "O     ",
              "XXOO  ",
              "OOXO  ",
              "XXOX  ",
              "XXXOX ",
              "OOXXO ",
              "X     " };

    @Test
    public void diagonalMatchLowerLeftUpperRight_Middle() throws GameException {
        logger.warn("Running diagonalMatchLowerLeftUpperRight_Middle");
        logger.warn("-----------------------------------------------");
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_Middle);

        assertFalse(winDetector.hasVerticalMatch(board[3]));
        assertFalse(winDetector.hasHorizontalMatch(board, 3));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 3));
        assertTrue(winDetector.hasDiagonalMatch(board, 3));
        assertTrue(winDetector.hasWinner(board, 3));
    }

    String diagonalMatchLowerLeftUpperRight_LowerLeft[] =
            { "XOOX  ",
              "OXXOO ",
              "OOX   ",
              "XXOX  ",
              "      ",
              "OO    ",
              "X     " };

    @Test
    public void diagonalMatchLowerLeftUpperRight_LowerLeft() throws GameException {
        logger.warn("Running diagonalMatchLowerLeftUpperRight_LowerLeft");
        logger.warn("--------------------------------------------------");
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_LowerLeft);

        assertFalse(winDetector.hasVerticalMatch(board[2]));
        assertFalse(winDetector.hasHorizontalMatch(board, 2));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 2));
        assertTrue(winDetector.hasDiagonalMatch(board, 2));
        assertTrue(winDetector.hasWinner(board, 2));
    }

    String diagonalMatchLowerLeftUpperRight_UpperLeft[] =
            { "OOX   ",
              "XXOX  ",
              "OOXOX ",
              "XXOXXX",
              "X     ",
              "OO    ",
              "XXOOXX" };

    @Test
    public void diagonalMatchLowerLeftUpperRight_UpperLeft() throws GameException {
        logger.warn("Running diagonalMatchLowerLeftUpperRight_UpperLeft");
        logger.warn("--------------------------------------------------");
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_UpperLeft);

        assertFalse(winDetector.hasVerticalMatch(board[3]));
        assertFalse(winDetector.hasHorizontalMatch(board, 3));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 3));
        assertTrue(winDetector.hasDiagonalMatch(board, 3));
        assertTrue(winDetector.hasWinner(board, 3));
    }

    String diagonalMatchLowerLeftUpperRight_LowerRight[] =
            { "      ",
               "XXOO  ",
               "OOXO  ",
               "OXOX  ",
               "XOXO  ",
               "OOO   ",
               "XXXO  " };

    @Test
    public void diagonalMatchLowerLeftUpperRight_LowerRight() throws GameException {
        logger.warn("Running diagonalMatchLowerLeftUpperRight_LowerRight");
        logger.warn("--------------------------------------------------");
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_LowerRight);

        assertFalse(winDetector.hasVerticalMatch(board[6]));
        assertFalse(winDetector.hasHorizontalMatch(board, 6));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 6));
        assertTrue(winDetector.hasDiagonalMatch(board, 6));
        assertTrue(winDetector.hasWinner(board, 6));
    }

    String diagonalMatchLowerLeftUpperRight_UpperRight[] =
            { "X     ",
                    "XXOO  ",
                    "X     ",
                    "OOOXOX",
                    "XXXO  ",
                    "OOXXO ",
                    "XXOXOO"};

    @Test
    public void diagonalMatchLowerLeftUpperRight_UpperRight() throws GameException {
        logger.warn("Running diagonalMatchLowerLeftUpperRight_UpperRight");
        logger.warn("--------------------------------------------------");
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, null);
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_UpperRight);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertFalse(winDetector.hasHorizontalMatch(board, 4));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }
}
