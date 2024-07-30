package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

import java.util.List;

public interface ColumnValidator {
    boolean isValidColumn(int column) throws BoardStateException;
    //int[] getValidColumnArray();
    //List<Integer> getValidColumnList();
    //List<Integer> getInvalidColumnList();
}
