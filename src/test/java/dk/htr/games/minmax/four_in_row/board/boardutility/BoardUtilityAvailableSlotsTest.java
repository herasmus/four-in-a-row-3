package dk.htr.games.minmax.four_in_row.board.boardUtility;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class BoardHandlerAvailableSlotsTest {
    // 2x4x3 board
    final static GameDimensions gameDim2x4x3 = new GameDimensions(2, 4, 3);
    final static ColumnStringOperations columnOperations2x4x3 = new ColumnStringOperations(gameDim2x4x3);

    // 5x4x3 board
    final static GameDimensions gameDim5x4x3 = new GameDimensions(5, 4, 3);
    final static ColumnStringOperations columnOperations5x4x3 = new ColumnStringOperations(gameDim5x4x3);


    @Test
    public void noAvailableSlots() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        BoardUtility boardUtility = new BoardUtility(gameDim2x4x3, columnOperations2x4x3);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim2x4x3, columnOperations2x4x3);
        BoardStateLogger boardStateLogger = new BoardStateLogger(boardState);

        final long board = 0b11000011_11001101L;
        byte res = boardUtility.getAvailableSlots(board);
        byte expected = 0b00000000;
        if(res != expected) {
            boardStateLogger.logBoardStateWarn(board);
        }
        assertEquals(expected, res);
    }

    /*
     *  5 x 4 board
     * -------------
     *
     *                           x
     *                           x                               o
     *                           o                               x
     *                           x               o       x       o
     *                  ---------------------------------------------------
     *                   Column: 1       2       3       4       5
     */
    @Test
    public void someAvailableSlots() throws GameException {
        GameDimensions gameDim5x4x3 = new GameDimensions(5, 4, 3);
        ColumnStringOperations columnOperations5x4x3 = new ColumnStringOperations(gameDim5x4x3);

        // Constructing stuff manually - todo Dependency injection?
        BoardUtility boardHandler = new BoardUtility(gameDim5x4x3, columnOperations5x4x3);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim5x4x3, columnOperations5x4x3);
        BoardStateLogger boardStateLogger = new BoardStateLogger(boardState);

        final long board = 0b00111010_00000001_00111110_10000000_11001101L;
        byte got = boardHandler.getAvailableSlots(board);
        byte expected = 0b00011110;
        if(got != expected) {
            boardStateLogger.logBoardStateWarn(board);
        }
        assertEquals(expected, got);
    }

    @Test
    public void maxAvailableSlots() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        BoardUtility boardUtility = new BoardUtility(gameDim5x4x3, columnOperations5x4x3);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim5x4x3, columnOperations5x4x3);
        BoardStateLogger boardStateLogger = new BoardStateLogger(boardState);

        final long board = 0b01111010_00000001_00000010_01111110_00000101L;
        byte res = boardUtility.getAvailableSlots(board);
        byte expected = 0b00011111;
        if(res != expected) {
            boardStateLogger.logBoardStateWarn(board);
        }
        assertEquals(expected, res);
    }
}
