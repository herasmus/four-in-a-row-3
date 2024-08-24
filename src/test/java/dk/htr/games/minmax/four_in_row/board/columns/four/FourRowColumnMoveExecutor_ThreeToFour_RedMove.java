package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_ThreeToFour_RedMove {
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();

    /*
     * Initial state    End state
     * 4                   O
     * 3  O                O
     * 2  O                O
     * 1  O                O
     *
     * Before:   0111_1000
     * Expected: 1100_0000
     */
    @Test
    public void move_OOOE_to_OOOO() throws BoardStateException {
        assertEquals(COLUMN_4R_OOOO.getIntValue(), columnMoves.moveRed(COLUMN_4R_OOOE.getIntValue()));
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  O                O
     * 2  O                O
     * 1  X                X
     *
     * Before:   0111_1001
     * Expected: 1100_0001
     */
    @Test
    public void move_XOOE_to_XOOO() throws BoardStateException {
        int result = columnMoves.moveRed(COLUMN_4R_XOOE.getIntValue());
        assertEquals(COLUMN_4R_XOOO.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  O                O
     * 2  X                X
     * 1  O                O
     *
     * Before:   0111_1010
     * Expected: 1100_0010
     */
    @Test
    public void move_OXOE_to_OXOO() throws BoardStateException {
        int result = columnMoves.moveRed(COLUMN_4R_OXOE.getIntValue());
        assertEquals(COLUMN_4R_OXOO.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  O                O
     * 2  X                X
     * 1  X                X
     *
     * Before:   0111_1011
     * Expected: 1100_0011
     */
    @Test
    public void move_XXOE_to_XXOO() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_4R_XXOE.getIntValue());
        assertEquals(COLUMN_4R_XXOO.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  X                X
     * 2  O                O
     * 1  O                O
     *
     * Before:   0000_0100
     * Expected: 1100_0100
     */
    @Test
    public void move_OOXE_to_OOXO() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_4R_OOXE.getIntValue());
        assertEquals(COLUMN_4R_OOXO.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  X                X
     * 2  O                O
     * 1  X                X
     *
     * Before:   0000_0101
     * Expected: 1100_0101
     */
    @Test
    public void move_XOXE_to_XOXO() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_4R_XOXE.getIntValue());
        assertEquals(COLUMN_4R_XOXO.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  X                X
     * 2  X                X
     * 1  O                O
     *
     * Before:   0000_0110
     * Expected: 1100_0110
     */
    @Test
    public void move_OXXE_to_OXXE() throws BoardStateException {
        assertEquals(COLUMN_4R_OXXO.getIntValue(), columnMoves.moveRed(COLUMN_4R_OXXE.getIntValue()));
    }

    /*
     * Initial state    End state
     * 4                   O
     * 3  X                X
     * 2  X                X
     * 1  X                X
     *
     * Before:   0000_0111
     * Expected: 1100_0111
     */
    @Test
    public void move_XXXE_to_XXXO() throws BoardStateException {
        assertEquals(COLUMN_4R_XXXO.getIntValue(), columnMoves.moveRed(COLUMN_4R_XXXE.getIntValue()));
    }
}
