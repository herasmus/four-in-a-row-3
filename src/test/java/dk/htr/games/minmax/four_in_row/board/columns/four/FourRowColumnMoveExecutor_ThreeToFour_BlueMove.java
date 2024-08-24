package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.COLUMN_4R_OOOE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_ThreeToFour_BlueMove {
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();

    /*
     * Initial state    End state
     * 4                   X
     * 3  O                O
     * 2  O                O
     * 1  O                O
     *
     * Before:   0111_1000
     * Expected: 1100_1000
     */
    @Test
    public void move_OOOE_to_OOOX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_OOOE.getIntValue());
        assertEquals(COLUMN_4R_OOOX.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  O                O
     * 2  O                O
     * 1  X                X
     *
     * Before:   0111_1001
     * Expected: 1100_1001
     */
    @Test
    public void move_XOOE_to_XOOX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_XOOE.getIntValue());
        assertEquals(COLUMN_4R_XOOX.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  O                O
     * 2  X                X
     * 1  O                O
     *
     * Before:   0111_1010
     * Expected: 1100_1010
     */
    @Test
    public void move_OXOE_to_OXOX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_OXOE.getIntValue());
        assertEquals(COLUMN_4R_OXOX.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  O                O
     * 2  X                X
     * 1  X                X
     *
     * Before:   0111_1011
     * Expected: 1100_1011
     */
    @Test
    public void move_XXOE_to_XXOX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_XXOE.getIntValue());
        assertEquals(COLUMN_4R_XXOX.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  X                X
     * 2  O                O
     * 1  O                O
     *
     * Before:   0000_0100
     * Expected: 1100_1100
     */
    @Test
    public void move_OOXE_to_OOXX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_OOXE.getIntValue());
        assertEquals(COLUMN_4R_OOXX.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  X                X
     * 2  O                O
     * 1  X                X
     *
     * Before:   0000_0101
     * Expected: 1100_1101
     */
    @Test
    public void move_XOXE_to_XOXX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_XOXE.getIntValue());
        assertEquals(COLUMN_4R_XOXX.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  X                X
     * 2  X                X
     * 1  O                O
     *
     * Before:   0000_0110
     * Expected: 1100_1110
     */
    @Test
    public void move_OXXE_to_OXXX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_OXXE.getIntValue());
        assertEquals(COLUMN_4R_OXXX.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4                   X
     * 3  X                X
     * 2  X                X
     * 1  X                X
     *
     * Before:   0000_01110
     * Expected: 1100_1111
     */
    @Test
    public void move_XXXE_to_XXXX() throws BoardStateException {
        assertEquals(COLUMN_4R_XXXX.getIntValue(), columnMoves.moveBlue(COLUMN_4R_XXXE.getIntValue()));
    }
}
