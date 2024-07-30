package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;


public class ColumnUtility {
    public static int getNumberDiscs(char[] column) throws GameException {
        int result = 0;
        for(int i = column.length - 1; i >= 0; i--) {
            if(column[i] != ' ') {
                result = i + 1;
                break;
            }
        }
        return result;
    }
}
