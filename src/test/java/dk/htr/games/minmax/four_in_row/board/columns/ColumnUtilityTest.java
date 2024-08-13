package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.*;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.COLUMN_4R_OOOX;
import static org.junit.jupiter.api.Assertions.*;

public class ColumnUtilityTest {
    final static GameDimensions gameDim2x4x3 = new GameDimensions(2, 4, 3);
    final static GameDimensions gameDim2x5x3 = new GameDimensions(2, 5, 3);

    @Test
    public void getNumberOfCounters() throws GameException {
        // Dimensions not used or needed here
        var columnUtility = new ColumnUtility(null);

        char[] column1 = { X, O, X, O, E, E};
        char[] column2 = { X, E, E, E};
        char[] column3 = { E, E, E, E};
        char[] column4 = { X, X, X, O, X, O};
        assertEquals(4, columnUtility.getNumberDiscs(column1));
        assertEquals(1, columnUtility.getNumberDiscs(column2));
        assertEquals( 0, columnUtility.getNumberDiscs(column3));
        assertEquals(6, columnUtility.getNumberDiscs(column4));
    }

    @Test
    public void isValidColumn_validColumnFourRows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        int validColumn = COLUMN_4R_OOOX.getIntValue();
        assertTrue(columnUtility.isValidColumn(validColumn));
    }

    @Test
    public void isValidColumn_invalidColumnFourRows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        int invalidColumn = 0b1111_1111;
        assertFalse(columnUtility.isValidColumn(invalidColumn));
    }

    @Test
    public void isValidColumn_validColumnSixRows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        fail();
    }

    @Test
    public void isValidColumn_invalidColumnSixRows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        fail();
    }

    @Test
    public void isValidColumn_InvalidNumberOfRows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x5x3);
        int validColumn = COLUMN_4R_OOOX.getIntValue();

        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            columnUtility.isValidColumn(0x100);
        }, "BoardStateException was expected");

        Assertions.assertEquals("Only 4 rows supported at the moment", thrown.getMessage());
    }

    @Test
    public void convert_ValidColumnFourRows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        int validColumn = COLUMN_4R_OOOX.getIntValue();
        char[] result = columnUtility.convert(validColumn);
        assertArrayEquals(result, COLUMN_4R_OOOX.getCharRepresentation());

    }

    @Test
    public void convert_ValidColumnFourRows_invalidColumn() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        int invalidColumn = 0b1111_1111;
        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            columnUtility.convert(invalidColumn);
        }, "BoardStateException was expected");

        Assertions.assertEquals("No array representation for invalid column", thrown.getMessage());
    }

    @Test
    public void convert_ValidColumnSixRows_validColumn() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        fail();
    }

    @Test
    public void convert_ValidColumnSixRows_invalidColumn() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        fail();
    }

    @Test
    public void convert_InvalidNumberOfRows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x5x3);
        int validColumn = COLUMN_4R_OOOX.getIntValue();
        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            columnUtility.convert(0x100);
        }, "BoardStateException was expected");

        Assertions.assertEquals("Only 4 rows supported at the moment", thrown.getMessage());
    }
}
