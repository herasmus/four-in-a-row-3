package dk.htr.games.minmax.four_in_row.board.boardutility;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardUtilityCreateInitialBoardTest {
    // 2x4x3 board
    final static GameDimensions gameDim2x4x3 = new GameDimensions(2, 4, 3);
    final static ColumnStringOperations columnOperations2x4x3 = new ColumnStringOperations(gameDim2x4x3);

    // 5x4x3 board
    final static GameDimensions gameDim5x4x3 = new GameDimensions(5, 4, 3);
    final static ColumnStringOperations columnOperations5x4x3 = new ColumnStringOperations(gameDim5x4x3);

    @Test
    public void createInitialBoard_2Columns4Rows() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        BoardUtility boardUtility = new BoardUtility(gameDim2x4x3, columnUtility, columnOperations2x4x3);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim2x4x3, columnOperations2x4x3);
        BoardStateLogger boardStateLogger = new BoardStateLogger(boardState);

        long board = boardUtility.createInitialBoard();
        assertEquals(0b1000_0000_1000_0000L, board);
    }

    @Test
    public void createInitialBoard_5Columns4Rows() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility columnUtility = new ColumnUtility(gameDim5x4x3);
        BoardUtility boardUtility = new BoardUtility(gameDim5x4x3, columnUtility, columnOperations5x4x3);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim5x4x3, columnOperations5x4x3);
        BoardStateLogger boardStateLogger = new BoardStateLogger(boardState);

        long board = boardUtility.createInitialBoard();
        assertEquals(0b1000_0000_1000_0000_1000_0000_1000_0000_1000_0000L, board);
    }
}
