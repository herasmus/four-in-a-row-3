package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

public interface ColumnMoveExecutor {
    int moveBlue(int presentColumn) throws BoardStateException;
    int moveRed(int presentColumn) throws BoardStateException;
}
