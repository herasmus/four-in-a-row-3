package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnMoveExecutor;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.*;

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
        RED_MOVES_4R[COLUMN_EMPTY.getIntValue()]  = COLUMN_O.getIntValue();
        BLUE_MOVES_4R[COLUMN_EMPTY.getIntValue()] = COLUMN_X.getIntValue();

        // 1 counter -> 2 counters
        RED_MOVES_4R[COLUMN_O.getIntValue()]  = COLUMN_OO.getIntValue();
        RED_MOVES_4R[COLUMN_X.getIntValue()]  = COLUMN_OX.getIntValue();
        BLUE_MOVES_4R[COLUMN_O.getIntValue()] = COLUMN_XO.getIntValue();
        BLUE_MOVES_4R[COLUMN_X.getIntValue()] = COLUMN_XX.getIntValue();

        // 2 counter -> 3 counters
        RED_MOVES_4R[COLUMN_OO.getIntValue()]  = COLUMN_OOO.getIntValue();
        RED_MOVES_4R[COLUMN_OX.getIntValue()]  = COLUMN_OOX.getIntValue();
        RED_MOVES_4R[COLUMN_XO.getIntValue()]  = COLUMN_OXO.getIntValue();
        RED_MOVES_4R[COLUMN_XX.getIntValue()]  = COLUMN_OXX.getIntValue();
        BLUE_MOVES_4R[COLUMN_OO.getIntValue()] = COLUMN_XOO.getIntValue();
        BLUE_MOVES_4R[COLUMN_OX.getIntValue()] = COLUMN_XOX.getIntValue();
        BLUE_MOVES_4R[COLUMN_XO.getIntValue()] = COLUMN_XXO.getIntValue();
        BLUE_MOVES_4R[COLUMN_XX.getIntValue()] = COLUMN_XXX.getIntValue();

        // 3 counter -> 4 counters
        // Red move
        RED_MOVES_4R[COLUMN_OOO.getIntValue()] = COLUMN_4R_OOOO.getIntValue();
        RED_MOVES_4R[COLUMN_OOX.getIntValue()] = COLUMN_4R_OOOX.getIntValue();
        RED_MOVES_4R[COLUMN_OXO.getIntValue()] = COLUMN_4R_OOXO.getIntValue();
        RED_MOVES_4R[COLUMN_OXX.getIntValue()] = COLUMN_4R_OOXX.getIntValue();
        RED_MOVES_4R[COLUMN_XOO.getIntValue()] = COLUMN_4R_OXOO.getIntValue();
        RED_MOVES_4R[COLUMN_XOX.getIntValue()] = COLUMN_4R_OXOX.getIntValue();
        RED_MOVES_4R[COLUMN_XXO.getIntValue()] = COLUMN_4R_OXXO.getIntValue();
        RED_MOVES_4R[COLUMN_XXX.getIntValue()] = COLUMN_4R_OXXX.getIntValue();

        // 3 counter -> 4 counters
        // Blue move
        BLUE_MOVES_4R[COLUMN_OOO.getIntValue()] = COLUMN_4R_XOOO.getIntValue();
        BLUE_MOVES_4R[COLUMN_OOX.getIntValue()] = COLUMN_4R_XOOX.getIntValue();
        BLUE_MOVES_4R[COLUMN_OXO.getIntValue()] = COLUMN_4R_XOXO.getIntValue();
        BLUE_MOVES_4R[COLUMN_OXX.getIntValue()] = COLUMN_4R_XOXX.getIntValue();
        BLUE_MOVES_4R[COLUMN_XOO.getIntValue()] = COLUMN_4R_XXOO.getIntValue();
        BLUE_MOVES_4R[COLUMN_XOX.getIntValue()] = COLUMN_4R_XXOX.getIntValue();
        BLUE_MOVES_4R[COLUMN_XXO.getIntValue()] = COLUMN_4R_XXXO.getIntValue();
        BLUE_MOVES_4R[COLUMN_XXX.getIntValue()] = COLUMN_4R_XXXX.getIntValue();
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
