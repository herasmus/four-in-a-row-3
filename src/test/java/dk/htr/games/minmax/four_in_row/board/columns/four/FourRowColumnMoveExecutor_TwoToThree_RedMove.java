package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_TwoToThree_RedMove {
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();

    /*
     * Initial state    End state
     * 4
     * 3                   O
     * 2  O                O
     * 1  O                O
     *
     * Before:   0111_1100
     * Expected: 0111_1000
     */
    @Test
    public void move_OOEE_to_OOOE() throws BoardStateException {
        int result   = columnMoves.moveRed(COLUMN_4R_OOEE.getIntValue());
        assertEquals(COLUMN_4R_OOOE.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   O
     * 2  X                X
     * 1  O                O
     *
     * Before:   0000_0010
     * Expected: 0111_1010
     */
    @Test
    public void move_OXEE_to_OXOE() throws GameException {
        int result   = columnMoves.moveRed(COLUMN_4R_OXEE.getIntValue());
        assertEquals(COLUMN_4R_OXOE.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   O
     * 2  O                O
     * 1  X                X
     *
     * Before:   0000_000X
     * Expected: 0111_1001
     */
    @Test
    public void move_XOEE_to_XOOE() throws GameException {
        int result   = columnMoves.moveRed(COLUMN_4R_XOEE.getIntValue());
        assertEquals(COLUMN_4R_XOOE.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3                   O
     * 2  X                X
     * 1  X                X
     *
     * Before:   0000_0001
     * Expected: 0000_0011
     */
    @Test
    public void move_XXEE_to_XXOE() throws GameException {
        int result   = columnMoves.moveRed(COLUMN_4R_XXEE.getIntValue());
        assertEquals(COLUMN_4R_XXOE.getIntValue(), result);
    }
}
