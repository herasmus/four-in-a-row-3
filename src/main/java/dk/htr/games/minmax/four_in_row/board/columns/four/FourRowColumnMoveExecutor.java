package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnMoveExecutor;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;
import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.COLUMN_4R_XXXE;

public class FourRowColumnMoveExecutor implements ColumnMoveExecutor {
    final protected static int[]  RED_MOVES_4R;
    final protected static int[]  BLUE_MOVES_4R;
    FourRowColumnValidator columnValidator = new FourRowColumnValidator();

    static {
        RED_MOVES_4R = new int[256];
        for(int i = 0; i < 256; i++) {
            RED_MOVES_4R[i] = -1;
        }

        BLUE_MOVES_4R = new int[256];
        for(int i = 0; i < 256; i++) {
            BLUE_MOVES_4R[i] = -1;
        }

        // Empty -> 1 counter
        RED_MOVES_4R[COLUMN_4R_EEEE.getIntValue()]  = COLUMN_4R_OEEE.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_EEEE.getIntValue()] = COLUMN_4R_XEEE.getIntValue();

        // 1 counter -> 2 counters
        RED_MOVES_4R[COLUMN_4R_OEEE.getIntValue()]  = COLUMN_4R_OOEE.getIntValue();
        RED_MOVES_4R[COLUMN_4R_XEEE.getIntValue()]  = COLUMN_4R_XOEE.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_OEEE.getIntValue()] = COLUMN_4R_OXEE.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_XEEE.getIntValue()] = COLUMN_4R_XXEE.getIntValue();

        // 2 counter -> 3 counters
        RED_MOVES_4R[COLUMN_4R_OOEE.getIntValue()]  = COLUMN_4R_OOOE.getIntValue();
        RED_MOVES_4R[COLUMN_4R_OXEE.getIntValue()]  = COLUMN_4R_OXOE.getIntValue();
        RED_MOVES_4R[COLUMN_4R_XOEE.getIntValue()]  = COLUMN_4R_XOOE.getIntValue();
        RED_MOVES_4R[COLUMN_4R_XXEE.getIntValue()]  = COLUMN_4R_XXOE.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_OOEE.getIntValue()] = COLUMN_4R_OOXE.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_OXEE.getIntValue()] = COLUMN_4R_OXXE.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_XOEE.getIntValue()] = COLUMN_4R_XOXE.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_XXEE.getIntValue()] = COLUMN_4R_XXXE.getIntValue();

        // 3 counter -> 4 counters
        // Red move
        RED_MOVES_4R[COLUMN_4R_OOOE.getIntValue()] = COLUMN_4R_OOOO.getIntValue();
        RED_MOVES_4R[COLUMN_4R_XOOE.getIntValue()] = COLUMN_4R_XOOO.getIntValue();
        RED_MOVES_4R[COLUMN_4R_OXOE.getIntValue()] = COLUMN_4R_OXOO.getIntValue();
        RED_MOVES_4R[COLUMN_4R_XXOE.getIntValue()] = COLUMN_4R_XXOO.getIntValue();
        RED_MOVES_4R[COLUMN_4R_OOXE.getIntValue()] = COLUMN_4R_OOXO.getIntValue();
        RED_MOVES_4R[COLUMN_4R_XOXE.getIntValue()] = COLUMN_4R_XOXO.getIntValue();
        RED_MOVES_4R[COLUMN_4R_OXXE.getIntValue()] = COLUMN_4R_OXXO.getIntValue();
        RED_MOVES_4R[COLUMN_4R_XXXE.getIntValue()] = COLUMN_4R_XXXO.getIntValue();

        // 3 counter -> 4 counters
        // Blue move
        BLUE_MOVES_4R[COLUMN_4R_OOOE.getIntValue()] = COLUMN_4R_OOOX.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_XOOE.getIntValue()] = COLUMN_4R_XOOX.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_OXOE.getIntValue()] = COLUMN_4R_OXOX.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_XXOE.getIntValue()] = COLUMN_4R_XXOX.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_OOXE.getIntValue()] = COLUMN_4R_OOXX.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_XOXE.getIntValue()] = COLUMN_4R_XOXX.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_OXXE.getIntValue()] = COLUMN_4R_OXXX.getIntValue();
        BLUE_MOVES_4R[COLUMN_4R_XXXE.getIntValue()] = COLUMN_4R_XXXX.getIntValue();
    }

    public int moveBlue(int column) throws BoardStateException {
        if(!columnValidator.isValidColumn(column)) {
            throw new BoardStateException("Invalid column " + column);
        }
        int moveResult = BLUE_MOVES_4R[column];
        if(moveResult == -1) {
            throw new BoardStateException("Invalid move (blue). Column before move: " + column);
        }
        return  moveResult;
    }

    public int moveRed(int column) throws BoardStateException {
        if(!columnValidator.isValidColumn(column)) {
            throw new BoardStateException("Invalid column " + column);
        }
        int moveResult = RED_MOVES_4R[column];
        if(moveResult == -1) {
            throw new BoardStateException("Invalid move (red). Column before move: " + column);
        }
        return  moveResult;
    }
}
