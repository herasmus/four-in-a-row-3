package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dk.htr.games.minmax.four_in_row.board.BinaryStringHelper.columnToBinaryString;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FourRowColumnMoveExecutor_OneToTwo {
    private final Logger logger = LoggerFactory.getLogger(FourRowColumnMoveExecutor_OneToTwo.class);
    FourRowColumnMoveExecutor columnMoves = new FourRowColumnMoveExecutor();

    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   O
     * 1  O                O
     *
     * Before:   0111_1110
     * Expected: 0111_1100
     */
    @Test
    public void move_O_to_OO() throws GameException {
        int expected = COLUMN_OO.getIntValue();
        int result   = columnMoves.moveRed(COLUMN_O.getIntValue());
        if(expected != result) {
            String gotStr = columnToBinaryString(result);
            logger.error("Before: 0111_1110 -> Red (0) -> Expected result: 01111100  <-- Got: " + gotStr);
        }
        assertEquals(expected, result);
    }

    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   X
     * 1  O                O
     *
     * Before:   0111_1110
     * Expected: 0000_0010
     */
    @Test
    public void move_O_to_XO() throws GameException {
        int expected = COLUMN_XO.getIntValue();
        int result   = columnMoves.moveBlue(COLUMN_O.getIntValue());
        assertEquals(COLUMN_XO.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   O
     * 1  X                X
     *
     * Before:   0000_000X
     * Expected: 0111_1101
     */
    @Test
    public void move_X_to_OX() throws GameException {
        int result   = columnMoves.moveRed(COLUMN_X.getIntValue());
        assertEquals(COLUMN_OX.getIntValue(), result);
    }

    /*
     * Initial state    End state
     * 4
     * 3
     * 2                   X
     * 1  X                X
     *
     * Before:   0000_0001
     * Expected: 0000_0011
     */
    @Test
    public void move_X_to_XX() throws GameException {
        int result   = columnMoves.moveBlue(COLUMN_X.getIntValue());
        assertEquals(COLUMN_XX.getIntValue(), result);
    }
}
