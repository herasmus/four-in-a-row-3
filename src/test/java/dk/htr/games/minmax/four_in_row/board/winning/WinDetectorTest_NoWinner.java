package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class WinDetectorTest_NoWinner {
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

    String noMatchFourToWin[] =
            { "O     ",
              "XOXO  ",
              "OOOX  ",
              "X     ",
              "XXX   ",
              "OXX   ",
              "OXXO  " };

    @Test
    public void noWinnerFourToWin() throws GameException {
        char[][] board = BoardCreator.createBoard(noMatchFourToWin);
        setNumberOfDiscsAndMoveColour(board, 0);
        assertEquals(0, winDetector.winner(board, 0));
        setNumberOfDiscsAndMoveColour(board, 1);
        assertEquals(0, winDetector.winner(board, 1));
        setNumberOfDiscsAndMoveColour(board, 2);
        assertEquals(0, winDetector.winner(board, 2));
        setNumberOfDiscsAndMoveColour(board, 3);
        assertEquals(0, winDetector.winner(board, 3));
        setNumberOfDiscsAndMoveColour(board, 4);
        assertEquals(0, winDetector.winner(board, 4));
        setNumberOfDiscsAndMoveColour(board, 5);
        assertEquals(0, winDetector.winner(board, 5));
        setNumberOfDiscsAndMoveColour(board, 6);
        assertEquals(0, winDetector.winner(board, 6));
    }
}
