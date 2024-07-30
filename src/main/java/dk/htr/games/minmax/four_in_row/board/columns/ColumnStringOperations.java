package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class ColumnStringOperations {
    @Autowired
    private final GameDimensions dimensions;

    private final static String underflowExcStr = "Underflow: Column: %s  String array length: %d  Bitnumber:  %d  Index: %d";
    private final static String overflowExcStr  = "Overflow:  Column: %s  String array length: %d  Bitnumber:  %d  Index: %d";

    private static void validateIndex(int column, int strArrayLength, int bitNumber, int index) throws GameException {
        String columnBinaryString =Integer.toBinaryString(column);
        if(index < 0) {
            String exceptionString = String.format(underflowExcStr, columnBinaryString, strArrayLength, bitNumber, index);
            throw new GameException(exceptionString);
        } else if((index + 1) > strArrayLength) {
            String exceptionString = String.format(overflowExcStr, columnBinaryString, strArrayLength, bitNumber, index);
            throw new GameException(exceptionString);
        }
    }

    private void addPartlyFilledColumn(int column, String[] rowStrings) throws GameException {
        /*        int bitNumber = 7;
        int fillerBitValue = getBit(column, bitNumber);
        int bitValue;
        do {
            if(bitNumber <= dimensions.getNrOfRows()) {
                int index = dimensions.getNrOfRows() - bitNumber;
                assert (index < 7 && index >= 0) : "Invalid index: " + index;
                rowStrings[index] += ". ";
            }
            bitNumber--;
            bitValue = getBit(column, bitNumber);
        } while(fillerBitValue == bitValue);
        // Real bits
        do {
            bitValue = getBit(column, bitNumber);
            char counterChar = bitValue == 1 ? 'x' : 'o';
            rowStrings[dimensions.getNrOfRows() - bitNumber] += "" + counterChar + ' ';
            bitNumber--;
        } while(bitNumber > 0);*/
    }

    private void addEmptyColumn(String[] rowStrings) {
        for (int rowNumber = 0; rowNumber < dimensions.getNrOfRows(); rowNumber++) {
            rowStrings[rowNumber] += ". ";
        }
    }

    private void addFullColumn(int column, String[] rowStrings) {
/*        for (int rowNumber = 0; rowNumber < dimensions.getNrOfRows(); rowNumber++) {
            int columnBit = getBit(column, dimensions.getNrOfRows() - rowNumber);
            char valChar = columnBit == 1 ? 'x' : 'o';
            rowStrings[rowNumber] += "" + valChar + ' ';
        }*/
    }

    public void addColumnStr(int columnState, String[] rowStrings) throws GameException {
/*        if (isEmpty(columnState)) {
            addEmptyColumn(rowStrings);
        } else if (isFull(columnState)) {
            addFullColumn(columnState, rowStrings);
        } else {
            addPartlyFilledColumn(columnState, rowStrings);
        }*/
    }
}
