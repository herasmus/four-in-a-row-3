package dk.htr.games.minmax.four_in_row.board.bits;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class BoardUtilityAvailableSlotsTest {
    // 2x4x3 board
    final static GameDimensions gameDim2x4x3 = new GameDimensions(2, 4, 3);

    // 5x4x3 board
    final static GameDimensions gameDim5x4x3 = new GameDimensions(5, 4, 3);

    @Test
    public void noAvailableSlots() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        BoardUtility boardUtility = new BoardUtility(gameDim2x4x3, columnUtility);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim2x4x3, boardUtility);
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

        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility columnUtility = new ColumnUtility(gameDim5x4x3);
        BoardUtility boardUtility = new BoardUtility(gameDim5x4x3, columnUtility);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim5x4x3, boardUtility);
        BoardStateLogger boardStateLogger = new BoardStateLogger(boardState);

        final long board = 0b00000010_00000001_11001001_00000100_11001101L;
        byte got = boardUtility.getAvailableSlots(board);
        byte expected = 0b00011010;
        if(got != expected) {
            boardStateLogger.logBoardStateWarn(board);
        }
        assertEquals(expected, got);
    }

    @Test
    public void maxAvailableSlots() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility columnUtility = new ColumnUtility(gameDim5x4x3);
        BoardUtility boardUtility = new BoardUtility(gameDim5x4x3, columnUtility);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim5x4x3, boardUtility);
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
