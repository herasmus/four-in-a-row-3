package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.O;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.X;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinDetectorTest_VerticalMatch {
    GameDimensions dimensions;
    ColumnUtility columnUtility;
    ColumnStringOperations columnStringOperations;
    BoardUtility boardUtility;
    BoardStateAsciiRenderer boardStateAsciiRenderer;
    BoardStateLogger boardStateLogger;
    BruteForceWinDetector winDetector;

    public WinDetectorTest_VerticalMatch() {
        dimensions = new GameDimensions(7, 6, 4);
        columnUtility = new ColumnUtility(dimensions);
        boardUtility = new BoardUtility(dimensions, columnUtility);
        boardStateAsciiRenderer = new BoardStateAsciiRenderer(dimensions, boardUtility);
        boardStateLogger = new BoardStateLogger(boardStateAsciiRenderer);
        winDetector = new BruteForceWinDetector(dimensions, columnUtility, boardStateLogger);
    }

    private void setNumberOfDiscs(char[][] board, int move) {
        char[] column = board[move];
        winDetector.numberOfDiscs = columnUtility.getNumberDiscs(column);
    }

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
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_Middle);

        // Not pretty - but important to see which match function is activated
        int move = 3;
        setNumberOfDiscs(board, move);
        assertTrue(winDetector.hasVerticalMatch(board[move]));
        assertEquals(O, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_LowerLeft);
        int move = 0;
        setNumberOfDiscs(board, move);
        assertTrue(winDetector.hasVerticalMatch(board[move]));
        assertEquals(O, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_UpperLeft);
        int move = 0;
        setNumberOfDiscs(board, move);
        assertTrue(winDetector.hasVerticalMatch(board[move]));
        assertEquals(O, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_LowerRight);
        int move = 6;
        setNumberOfDiscs(board, move);
        assertTrue(winDetector.hasVerticalMatch(board[move]));
        assertEquals(X, winDetector.winner(board, move));
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
        char[][] board = BoardCreator.createBoard(verticalMatchFourToWin_UpperRight);
        int move = 6;
        setNumberOfDiscs(board, move);
        assertTrue(winDetector.hasVerticalMatch(board[move]));
        assertEquals(O, winDetector.winner(board, move));
    }
}
