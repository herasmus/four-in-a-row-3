package dk.htr.games.minmax.four_in_row.board.columns;

import dk.htr.games.minmax.four_in_row.board.columns.four.FourRowColumnsUtility;
import dk.htr.games.minmax.four_in_row.board.columns.four.ValidFourRowColumns;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class ColumnUtility {
    final private GameDimensions dimensions;
    final static int COLUMN_FULL_MASK = 0b11000000;

    public int getNumberDiscs(char[] column) {
        int result = 0;
        for(int i = column.length - 1; i >= 0; i--) {
            if(column[i] != ' ') {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    public char[] convert(int column) throws BoardStateException {
        if (dimensions.getNrOfColumns() == 4) {
            return FourRowColumnsUtility.convert(column);
        }
        throw new BoardStateException("Only 4 rows supported at the moment");
    }

    public boolean isValidColumn(int column) throws BoardStateException {
        if (dimensions.getNrOfColumns() == 4) {
            return ValidFourRowColumns.isValidColumn(column);
        }
        throw new BoardStateException("Only 4 rows supported at the moment");
    }

    public boolean isFull(int column) {
        return ((column & COLUMN_FULL_MASK) == COLUMN_FULL_MASK);
    }
}
