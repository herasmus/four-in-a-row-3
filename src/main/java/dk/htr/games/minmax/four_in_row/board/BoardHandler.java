package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@RequiredArgsConstructor
@Component
public class BoardHandler {
    private final GameDimensions dimensions;
    private final ColumnStringOperations columnOperations;

/*
    public int moveColumn(int columnState, boolean isBluePlayer) throws GameException {
        int newColumnState;
        if(!ColumnValidatorOld.isValidColumnState(columnState, dimensions.getNrOfRows())) {
            throw new BoardStateException("Invalid Column state: " + columnState);
        }
        if(isBluePlayer) {
            newColumnState = moveBluePlayer(columnState);
        } else {
            newColumnState = moveRedPlayer(columnState);
        }
        return newColumnState;
    }*/

    /*
    public long move(long board, int move, boolean isBluePlayer) throws GameException {
        int columnState = -1;// = moveColumn(readByte(board, move), isBluePlayer);
        return writeByte(board, columnState, move);
    }*/

    /**
     * Return available slots as a bit-pattern:
     *
     * Example: Slot 1 and 4 is free will yield:
     *
     * 0b00001001
     *
     * @param board
     * @return
     */
    public byte getAvailableSlots(long board) {
        byte res = 0;
/*        byte shiftBit = 1;
        for(int columnNumber = 1; columnNumber <= dimensions.getNrOfColumns(); columnNumber++) {
            int column = (int)board & 0b11111111;
            if(!isFull(column)) {
                res |= shiftBit;
            }
            shiftBit <<= 1;
            board >>= 8;
        }*/
        return res;
    }

    public int getMoveResult(long board) {



        return -1;
    }
}
