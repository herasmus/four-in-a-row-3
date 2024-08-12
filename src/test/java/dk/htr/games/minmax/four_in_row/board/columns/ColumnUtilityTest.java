package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.*;
import static org.junit.jupiter.api.Assertions.*;

public class ColumnUtilityTest {
    final static GameDimensions gameDim2x4x3 = new GameDimensions(2, 4, 3);

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
    public void validColumnFourRows() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility boardUtility = new ColumnUtility(gameDim2x4x3);

        fail();
    }

    @Test
    public void invalidColumnFourRows() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility boardUtility = new ColumnUtility(gameDim2x4x3);

        fail();
    }

    @Test
    public void validColumnSixRows() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility boardUtility = new ColumnUtility(gameDim2x4x3);

        fail();
    }

    @Test
    public void invalidColumnSixRows() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility boardUtility = new ColumnUtility(gameDim2x4x3);

        fail();
    }

    @Test
    public void invalidNumberOfColumnSixRows() throws GameException {
        // Constructing stuff manually - todo Dependency injection?
        ColumnUtility boardUtility = new ColumnUtility(gameDim2x4x3);

        fail();
    }
}
