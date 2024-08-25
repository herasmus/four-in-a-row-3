package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class WinDetectorTest_DiagonalMatch_UpperLeftToLowerRight {
    Logger logger = LoggerFactory.getLogger(WinDetectorTest_DiagonalMatch_UpperLeftToLowerRight.class);
    GameDimensions dimensions = new GameDimensions(7, 6, 4);
    ColumnUtility columnUtility = new ColumnUtility(dimensions);
    BoardUtility boardUtility = new BoardUtility(dimensions, columnUtility);
    BoardStateAsciiRenderer boardStateAsciiRenderer = new BoardStateAsciiRenderer(dimensions, boardUtility);
    BoardStateLogger boardStateLogger = new BoardStateLogger(boardStateAsciiRenderer);
    WinDetectorImpl winDetector = new WinDetectorImpl(dimensions, columnUtility, boardStateLogger);

    String diagonalMatchUpperLeftLowerRight_Middle[] =
            { "O     ",
              "OXOO  ",
              "OXOOX ",
              "XOXXX ",
              "XOX   ",
              "OXO   ",
              "      " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_Middle() throws GameException {
        logger.warn("Running diagonalMatchLowerLeftUpperRight_Middle");
        logger.warn("-----------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_Middle);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertFalse(winDetector.hasHorizontalMatch(board, 4));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }

    String diagonalMatchUpperLeftLowerRight_LowerLeft[] =
            { "O     ",
                    "OXOO  ",
                    "OXOOX ",
                    "XOXXX ",
                    "XOX   ",
                    "OXO   ",
                    "      " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_LowerLeft() throws GameException {
        logger.warn("Running adiagonalMatchUpperLeftLowerRight_LowerLeft");
        logger.warn("-----------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_LowerLeft);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertFalse(winDetector.hasHorizontalMatch(board, 4));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }

    String diagonalMatchUpperLeftLowerRight_UpperLeft[] =
            { "O     ",
                    "OXOO  ",
                    "OXOOX ",
                    "XOXXX ",
                    "XOX   ",
                    "OXO   ",
                    "      " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_UpperLeft() throws GameException {
        logger.warn("Running diagonalMatchUpperLeftLowerRight_UpperLeft");
        logger.warn("-----------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_UpperLeft);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertFalse(winDetector.hasHorizontalMatch(board, 4));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }

    String diagonalMatchUpperLeftLowerRight_LowerRight[] =
            { "O     ",
                    "OXOO  ",
                    "OXOOX ",
                    "XOXXX ",
                    "XOX   ",
                    "OXO   ",
                    "      " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_LowerRight() throws GameException {
        logger.warn("Running diagonalMatchUpperLeftLowerRight_LowerRight");
        logger.warn("-----------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_LowerRight);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertFalse(winDetector.hasHorizontalMatch(board, 4));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }

    String diagonalMatchUpperLeftLowerRight_UpperRight[] =
            { "O     ",
                    "OXOO  ",
                    "OXOOX ",
                    "XOXXX ",
                    "XOX   ",
                    "OXO   ",
                    "      " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_UpperRight() throws GameException {
        logger.warn("Running diagonalMatchUpperLeftLowerRight_UpperRight");
        logger.warn("---------------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_UpperRight);

        assertFalse(winDetector.hasVerticalMatch(board[4]));
        assertFalse(winDetector.hasHorizontalMatch(board, 4));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, 4));
        assertTrue(winDetector.hasDiagonalMatch(board, 4));
        assertTrue(winDetector.hasWinner(board, 4));
    }
}
