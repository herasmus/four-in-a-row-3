package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_TwoToThree_BlueMove {
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();
    /*
     * Initial state    End state
     * 4
     * 3                   X
     * 2  O                O
     * 1  O                O
     *
     * Before:   0111_1100
     * Expected: 0000_0100
     */
    @Test
    public void move_OOEE_to_OOXE() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_OOEE.getIntValue());
        assertEquals(COLUMN_4R_OOXE.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   X
     * 2  X                X
     * 1  O                O
     *
     * Before:   0000_0010
     * Expected: 0000_0110
     */
    @Test
    public void move_OXEE_to_OXXE() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_OXEE.getIntValue());
        assertEquals(COLUMN_4R_OXXE.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   X
     * 2  O                O
     * 1  X                X
     *
     * Before:   0111_1101
     * Expected: 0000_0101
     */
    @Test
    public void move_XOEE_to_XOXE() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_XOEE.getIntValue());
        assertEquals(COLUMN_4R_XOXE.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   X
     * 2  X                X
     * 1  X                X
     *
     * Before:   0000_0011
     * Expected: 0000_0111
     */
    @Test
    public void move_XXEE_to_XXXE() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_4R_XXEE.getIntValue());
        assertEquals(COLUMN_4R_XXXE.getIntValue(), result);
    }
}
