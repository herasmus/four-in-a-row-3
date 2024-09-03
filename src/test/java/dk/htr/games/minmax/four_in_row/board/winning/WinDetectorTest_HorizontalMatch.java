package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.O;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.X;
import static org.junit.jupiter.api.Assertions.*;

public class WinDetectorTest_HorizontalMatch {
    GameDimensions dimensions;
    ColumnUtility columnUtility;
    BoardUtility boardUtility;
    BoardStateAsciiRenderer boardStateAsciiRenderer;
    BoardStateLogger boardStateLogger;
    BruteForceWinDetector winDetector;

    public WinDetectorTest_HorizontalMatch() {
        dimensions = new GameDimensions(7, 6, 4);
        columnUtility = new ColumnUtility(dimensions);
        boardUtility = new BoardUtility(dimensions, columnUtility);
        boardStateAsciiRenderer = new BoardStateAsciiRenderer(dimensions, boardUtility);
        boardStateLogger = new BoardStateLogger(boardStateAsciiRenderer);
        winDetector = new BruteForceWinDetector(dimensions, columnUtility, boardStateLogger);
    }

    private void setNumberOfDiscsAndMoveColour(char[][] board, int move) {
        char[] column = board[move];
        winDetector.numberOfDiscs = columnUtility.getNumberDiscs(column);
        winDetector.thisMoveDiscColour = column[winDetector.numberOfDiscs - 1];
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
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_Middle);
        int move = 4;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertTrue(winDetector.hasHorizontalMatch(board, move));
        assertEquals(O, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_LowerLeft);
        int move = 0;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertTrue(winDetector.hasHorizontalMatch(board, move));
        assertEquals(X, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_UpperLeft);
        int move = 2;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertTrue(winDetector.hasHorizontalMatch(board, move));
        assertEquals(O, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_LowerRight);
        int move = 5;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertTrue(winDetector.hasHorizontalMatch(board, move));
        assertEquals(O, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(horizontalMatchFourToWin_UpperRight);
        int move = 3;
        setNumberOfDiscsAndMoveColour(board, move);
        assertFalse(winDetector.hasVerticalMatch(board[move]));
        assertTrue(winDetector.hasHorizontalMatch(board, move));
        assertEquals(O, winDetector.winner(board, move));
    }
}
