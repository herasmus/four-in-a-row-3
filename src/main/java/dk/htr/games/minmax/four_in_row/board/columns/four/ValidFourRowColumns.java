package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public enum ValidFourRowColumns {
    // Common
    COLUMN_EMPTY(0b1000_0000, ColumnStrings.COLUMN_EMPTY_STR),
    COLUMN_O(0b0111_1110, ColumnStrings.COLUMN_O_STR),
    COLUMN_X(0b0000_0001, ColumnStrings.COLUMN_X_STR),
    COLUMN_OO(0b0111_1100, ColumnStrings.COLUMN_OO_STR),
    COLUMN_OX(0b0111_1101, ColumnStrings.COLUMN_OX_STR),
    COLUMN_XO(0b0000_0010, ColumnStrings.COLUMN_XO_STR),
    COLUMN_XX(0b0000_0011, ColumnStrings.COLUMN_XX_STR),
    COLUMN_OOO(0b0111_1000, ColumnStrings.COLUMN_OOO_STR),
    COLUMN_OOX(0b0111_1001, ColumnStrings.COLUMN_OOX_STR),
    COLUMN_OXO(0b0111_1010, ColumnStrings.COLUMN_OXO_STR),
    COLUMN_OXX(0b0111_1011, ColumnStrings.COLUMN_OXX_STR),
    COLUMN_XOO(0b0000_0100, ColumnStrings.COLUMN_XOO_STR),
    COLUMN_XOX(0b0000_0101, ColumnStrings.COLUMN_XOX_STR),
    COLUMN_XXO(0b0000_0110, ColumnStrings.COLUMN_XXO_STR),
    COLUMN_XXX(0b0000_0111, ColumnStrings.COLUMN_XXX_STR),

    // specific for 4 rows column
    COLUMN_4R_OOOO(0b1100_0000, ColumnStrings.COLUMN_OOOO_STR),
    COLUMN_4R_OOOX(0b1100_0001, ColumnStrings.COLUMN_OOOX_STR),
    COLUMN_4R_OOXO(0b1100_0010, ColumnStrings.COLUMN_OOXO_STR),
    COLUMN_4R_OOXX(0b1100_0011, ColumnStrings.COLUMN_OOXX_STR),
    COLUMN_4R_OXOO(0b1100_0100, ColumnStrings.COLUMN_OXOO_STR),
    COLUMN_4R_OXOX(0b1100_0101, ColumnStrings.COLUMN_OXOX_STR),
    COLUMN_4R_OXXO(0b1100_0110, ColumnStrings.COLUMN_OXXO_STR),
    COLUMN_4R_OXXX(0b1100_0111, ColumnStrings.COLUMN_OXXX_STR),
    COLUMN_4R_XOOO(0b1100_1000, ColumnStrings.COLUMN_XOOO_STR),
    COLUMN_4R_XOOX(0b1100_1001, ColumnStrings.COLUMN_XOOX_STR),
    COLUMN_4R_XOXO(0b1100_1010, ColumnStrings.COLUMN_XOXO_STR),
    COLUMN_4R_XOXX(0b1100_1011, ColumnStrings.COLUMN_XOXX_STR),
    COLUMN_4R_XXOO(0b1100_1100, ColumnStrings.COLUMN_XXOO_STR),
    COLUMN_4R_XXOX(0b1100_1101, ColumnStrings.COLUMN_XXOX_STR),
    COLUMN_4R_XXXO(0b1100_1110, ColumnStrings.COLUMN_XXXO_STR),
    COLUMN_4R_XXXX(0b1100_1111, ColumnStrings.COLUMN_XXXX_STR);

    static final boolean[] columnValidity = new boolean[256];
    static final char[][] columnCharArray = new char[256][];
    static final List<Integer> intValueList = new ArrayList<Integer>();
    @Getter
    final int intValue;
    final char[] charRepresentation;

    static {
        for (ValidFourRowColumns c : ValidFourRowColumns.values()) {
            columnValidity[c.intValue] = true;
            intValueList.add(c.intValue);
            columnCharArray[c.intValue] = c.charRepresentation;
        }
    }

    ValidFourRowColumns(int intValue, char[] charRepresentation) {
        this.intValue = intValue;
        this.charRepresentation = charRepresentation;
    }

    public static char[] getCharArray(int column) throws BoardStateException {
        if ((column < 0)) throw new BoardStateException("Column state cant be less than 0x00");
        if ((column > 255)) throw new BoardStateException("Column state cant be greater than 0xFF");
        char[] result = columnCharArray[column];
        if(!isValidColumn(column)) {
            throw new BoardStateException("No array representation for invalid column");
        }
        return result;
    }

    public static boolean isValidColumn(int column) throws BoardStateException {
        if ((column < 0)) throw new BoardStateException("Column state cant be less than 0x00");
        if ((column > 255)) throw new BoardStateException("Column state cant be greater than 0xFF");
        return columnValidity[column];
    }
}
