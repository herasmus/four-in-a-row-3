package dk.htr.games.minmax.four_in_row.board.columns.four;

public class ColumnStrings {
    // Empty, O and X
    // E, O and X - in order to be able to change easily
    public final static char E = ' ';
    public final static char O  = 'O';
    public final static char X  = 'X';

    final static char[] COLUMN_EMPTY_STR = { E, E, E, E};
    final static char[] COLUMN_O_STR     = { E, E, E, O};
    final static char[] COLUMN_X_STR     = { E, E, E, X};
    final static char[] COLUMN_OO_STR    = { E, E, O, O};
    final static char[] COLUMN_OX_STR    = { E, E, O, X};
    final static char[] COLUMN_XO_STR    = { E, E, X, O};
    final static char[] COLUMN_XX_STR    = { E, E, X, X};
    final static char[] COLUMN_OOO_STR   = { E, O, O, O};
    final static char[] COLUMN_OOX_STR   = { E, O, O, X};
    final static char[] COLUMN_OXO_STR   = { E, O, X, O};
    final static char[] COLUMN_OXX_STR   = { E, O, X, X};
    final static char[] COLUMN_XOO_STR   = { E, X, O, O};
    final static char[] COLUMN_XOX_STR   = { E, X, O, X};
    final static char[] COLUMN_XXO_STR   = { E, X, X, O};
    final static char[] COLUMN_XXX_STR   = { E, X, X, X};
    final static char[] COLUMN_OOOO_STR  = { O, O, O, O};
    final static char[] COLUMN_OOOX_STR  = { O, O, O, X};
    final static char[] COLUMN_OOXO_STR  = { O, O, X, O};
    final static char[] COLUMN_OOXX_STR  = { O, O, X, X};
    final static char[] COLUMN_OXOO_STR  = { O, X, O, O};
    final static char[] COLUMN_OXOX_STR  = { O, X, O, X};
    final static char[] COLUMN_OXXO_STR  = { O, X, X, O};
    final static char[] COLUMN_OXXX_STR  = { O, X, X, X};
    final static char[] COLUMN_XOOO_STR  = { X, O, O, O};
    final static char[] COLUMN_XOOX_STR  = { X, O, O, X};
    final static char[] COLUMN_XOXO_STR  = { X, O, X, O};
    final static char[] COLUMN_XOXX_STR  = { X, O, X, X};
    final static char[] COLUMN_XXOO_STR  = { X, X, O, O};
    final static char[] COLUMN_XXOX_STR  = { X, X, O, X};
    final static char[] COLUMN_XXXO_STR  = { X, X, X, O};
    final static char[] COLUMN_XXXX_STR  = { X, X, X, X};
}
