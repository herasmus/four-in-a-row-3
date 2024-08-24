package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import dk.htr.games.minmax.four_in_row.board.bits.BinaryStringHelper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns.COLUMN_4R_EEEE;

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
    public byte getAvailableSlots(long board) throws BoardStateException {
        byte res = 0;
        byte shiftBit = 1;
        for(int columnNumber = 0; columnNumber < dimensions.getNrOfColumns(); columnNumber++) {
            int column = (int)board & 0b11111111;
            if(!columnUtility.isValidColumn(column)) {
                throw new BoardStateException("Invalid column: " + BinaryStringHelper.columnToBinaryString(column));
            };
            if(!columnUtility.isFull(column)) {
                res |= shiftBit;
            }
            shiftBit <<= 1;
            board >>= 8;
        }
        return res;
    }

    public char[][] convertToCharMatrix(long longBoard) throws BoardStateException {
        char[][] resultMatrix = new char[dimensions.getNrOfColumns()][];;
        for(int col = 0; col < dimensions.getNrOfColumns(); col++) {
            int column = (int)longBoard & 0b11111111;
            if(!columnUtility.isValidColumn(column)) {
                throw new BoardStateException("Invalid column: " + BinaryStringHelper.columnToBinaryString(column));
            };
            resultMatrix[col] = columnUtility.convert(column);
            longBoard >>= 8;
        }
        return resultMatrix;
    }

    public long createInitialBoard() {
        long result = 0;
        for(int col = 0; col < dimensions.getNrOfColumns(); col++) {
            result <<= 8;
            result |= COLUMN_4R_EEEE.getIntValue();
        }
        return result;
    }
}
