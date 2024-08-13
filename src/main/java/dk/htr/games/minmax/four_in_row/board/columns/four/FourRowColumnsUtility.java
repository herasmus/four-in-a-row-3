package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

public class FourRowColumnsUtility {
    public static char[] convert(int column) throws BoardStateException {
        return ValidFourRowColumns.getCharArray(column);
    }
}
