package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
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
    public void move_OOO_to_XOOO() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_OOO.getIntValue());
        assertEquals(COLUMN_4R_XOOO.getIntValue(), result);
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
    public void move_OOX_to_XOOX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_OOX.getIntValue());
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
    public void move_OXO_to_XOXO() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_OXO.getIntValue());
        assertEquals(COLUMN_4R_XOXO.getIntValue(), result);
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
    public void move_OXX_to_XOXX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_OXX.getIntValue());
        assertEquals(COLUMN_4R_XOXX.getIntValue(), result);
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
    public void move_XOO_to_XXOO() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_XOO.getIntValue());
        assertEquals(COLUMN_4R_XXOO.getIntValue(), result);
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
    public void move_XOX_to_XXOX() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_XOX.getIntValue());
        assertEquals(COLUMN_4R_XXOX.getIntValue(), result);
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
    public void move_XXO_to_XXXO() throws BoardStateException {
        int result   = columnMoves.moveBlue(COLUMN_XXO.getIntValue());
        assertEquals(COLUMN_4R_XXXO.getIntValue(), result);
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
    public void move_XXX_to_XXXX() throws BoardStateException {
        assertEquals(COLUMN_4R_XXXX.getIntValue(), columnMoves.moveBlue(COLUMN_XXX.getIntValue()));
    }
}
