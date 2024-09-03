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

import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.O;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.X;
import static org.junit.jupiter.api.Assertions.*;

public class WinDetectorTest_DiagonalMatch_UpperLeftToLowerRight {
    Logger logger = LoggerFactory.getLogger(WinDetectorTest_DiagonalMatch_UpperLeftToLowerRight.class);
    GameDimensions dimensions = new GameDimensions(7, 6, 4);
    ColumnUtility columnUtility = new ColumnUtility(dimensions);
    BoardUtility boardUtility = new BoardUtility(dimensions, columnUtility);
    BoardStateAsciiRenderer boardStateAsciiRenderer = new BoardStateAsciiRenderer(dimensions, boardUtility);
    BoardStateLogger boardStateLogger = new BoardStateLogger(boardStateAsciiRenderer);
    BruteForceWinDetector winDetector = new BruteForceWinDetector(dimensions, columnUtility, boardStateLogger);

    private void setNumberOfDiscsAndMoveColour(char[][] board, int move) {
        char[] column = board[move];
        winDetector.numberOfDiscs = columnUtility.getNumberDiscs(column);
        winDetector.thisMoveDiscColour = column[winDetector.numberOfDiscs - 1];
    }

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
        int move = 4;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(X, winDetector.winner(board, move));
    }

    String diagonalMatchUpperLeftLowerRight_LowerLeft[] =
            { "OXOO  ",
              "OXOOO ",
              "XOXXX ",
              "OOX   ",
              "OXO   ",
              "O     ",
              "      " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_LowerLeft() throws GameException {
        logger.warn("Running adiagonalMatchUpperLeftLowerRight_LowerLeft");
        logger.warn("-----------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_LowerLeft);
        int move = 4;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(O, winDetector.winner(board, move));
    }

    String diagonalMatchUpperLeftLowerRight_UpperLeft[] =
            { "OXXXOX",
              "OXOOX ",
              "OXOXX ",
              "XOXXX ",
              "      ",
              "OXO   ",
              "      " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_UpperLeft() throws GameException {
        logger.warn("Running diagonalMatchUpperLeftLowerRight_UpperLeft");
        logger.warn("-----------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_UpperLeft);
        int move = 1;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(X, winDetector.winner(board, move));
    }

    String diagonalMatchUpperLeftLowerRight_LowerRight[] =
            { "O     ",
                    "OXOO  ",
                    "      ",
                    "XOXX  ",
                    "XOX   ",
                    "OXO   ",
                    "X     " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_LowerRight() throws GameException {
        logger.warn("Running diagonalMatchUpperLeftLowerRight_LowerRight");
        logger.warn("-----------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_LowerRight);
        int move = 6;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(X, winDetector.winner(board, move));
    }

    String diagonalMatchUpperLeftLowerRight_UpperRight[] =
            { "O     ",
                    "OXOO  ",
                    "O     ",
                    "XOXXXO",
                    "XOXOO ",
                    "OXOO  ",
                    "OXO   " };

    @Test
    public void diagonalMatchUpperLeftLowerRight_UpperRight() throws GameException {
        logger.warn("Running diagonalMatchUpperLeftLowerRight_UpperRight");
        logger.warn("---------------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchUpperLeftLowerRight_UpperRight);
        int move = 5;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertFalse(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatchUpperLeftToLowerRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(O, winDetector.winner(board, move));
    }
}
