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

public class WinDetectorTest_DiagonalMatch_LowerLeftToUpperRight {
    Logger logger = LoggerFactory.getLogger(WinDetectorTest_DiagonalMatch_LowerLeftToUpperRight.class);
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
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_Middle);

        int move = 3;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(X, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_LowerLeft);
        int move = 2;
        setNumberOfDiscsAndMoveColour(board, move);

        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(X, winDetector.winner(board, move));
    }

    String diagonalMatchLowerLeftUpperRight_UpperLeft[] =
            { "OOX   ",
              "XXOX  ",
              "OOXOX ",
              "XXOXXX",
              "O     ",
              "OO    ",
              "XXOOXX" };

    @Test
    public void diagonalMatchLowerLeftUpperRight_UpperLeft() throws GameException {
        logger.warn("Running diagonalMatchLowerLeftUpperRight_UpperLeft");
        logger.warn("--------------------------------------------------");
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_UpperLeft);
        int move = 3;
        setNumberOfDiscsAndMoveColour(board, move);

        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, 3));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(X, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_LowerRight);
        int move = 6;
        setNumberOfDiscsAndMoveColour(board, move);

        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(O, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(diagonalMatchLowerLeftUpperRight_UpperRight);
        int move = 4;
        setNumberOfDiscsAndMoveColour(board, move);

        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertFalse(winDetector.hasHorizontalMatch(board, move));
        assertTrue(winDetector.hasDiagonalMatchLowerLeftToUpperRight(board, move));
        assertTrue(winDetector.hasDiagonalMatch(board, move));
        assertEquals(O, winDetector.winner(board, move));
    }
}
