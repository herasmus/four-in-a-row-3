package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * NOTE: All methods in this class is zero-based
 *       I.e. column and row numbers are zerobased
 *
 */
@Setter
@Getter
@RequiredArgsConstructor
@Component
public class BoardUtility {
    private final GameDimensions dimensions;
    private final ColumnUtility columnUtility;
    private final ColumnStringOperations columnOperations;
    /**
     * Return available slots as a bit-pattern:
     *
     * Example: Slot 0,3 and 4 is free will yield:
     *
     * 0b00011001
     *
     * @param board
     * @return
     */
    public byte getAvailableSlots(long board) {
        byte res = 0;
        byte shiftBit = 1;
        for(int columnNumber = 0; columnNumber < dimensions.getNrOfColumns(); columnNumber++) {
            int column = (int)board & 0b11111111;
            if(!columnUtility.isFull(column)) {
                res |= shiftBit;
            }
            shiftBit <<= 1;
            board >>= 8;
        }
        return res;
    }


    public char[][] convertLongToCharMatrix(long longBoard) {
        return null;
    }
}
