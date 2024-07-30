package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.*;
import static org.junit.jupiter.api.Assertions.*;

public class ColumnUtilityTest {
    @Test
    public void isColumnEmpty() {
    }

    @Test
    public void isColumnFull() {
}

    @Test
    public void getNumberOfCounters() throws GameException {
        char[] column1 = { X, O, X, O, E, E};
        char[] column2 = { X, E, E, E};
        char[] column3 = { E, E, E, E};
        char[] column4 = { X, X, X, O, X, O};
        assertEquals(4, ColumnUtility.getNumberDiscs(column1));
        assertEquals(1, ColumnUtility.getNumberDiscs(column2));
        assertEquals( 0, ColumnUtility.getNumberDiscs(column3));
        assertEquals(6, ColumnUtility.getNumberDiscs(column4));
    }
}
