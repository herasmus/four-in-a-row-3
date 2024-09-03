package dk.htr.games.minmax.four_in_row.board.render;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class BoardStateAsciiRenderer {
    private final GameDimensions dimensions;
    private final BoardUtility boardUtility;

    private void addRowNumbers(String[] rowStrings) {
        for(int rowNumber = 1; rowNumber <= dimensions.getNrOfRows(); rowNumber++) {
            rowStrings[rowNumber - 1] = " " + (dimensions.getNrOfRows() - rowNumber + 1) + "| ";
        }
    }

    private void addBottomLine(String[] rowStrings) {
        int nrOfColumns = dimensions.getNrOfColumns();
        rowStrings[dimensions.getNrOfRows()] = " " + String.valueOf('-').repeat((nrOfColumns + 1) * 2 + 1);
    }

    private void addColumnNumbers(String[] rowStrings) {
        rowStrings[dimensions.getNrOfRows() + 1] = "    ";
        for(int columnNr = 1; columnNr <= dimensions.getNrOfColumns(); columnNr++) {
            rowStrings[dimensions.getNrOfRows() + 1] += columnNr + " ";
        }
    }

    /*
     *  Example: 7 x 6
     *
     *  If the column isn't full, then bit 7 and 6,
     *  and all of the bits of same value in bit 5 and below
     *  (until another bitvalue is encountered) to be considered as empty counters
     *  denoted by a '.'
     *  1 = 'x'
     *  0 = 'o'
     *
     */
    public String[] getBoardStateAsciiImage(long board) throws GameException {
        return getBoardStateAsciiImage(boardUtility.convertToCharMatrix(board));
    }

    public String[] getBoardStateAsciiImage(char[][] board) throws GameException {

        // StringBuilder instead of Strings, since Strings ar em

        String[] rows = new String[dimensions.getNrOfRows() + 2];
        addRowNumbers(rows);
        for (int column = 0; column < dimensions.getNrOfColumns(); column++) {
            for (int row = 0; row < dimensions.getNrOfRows(); row++) {
                char ch = board[column][row];
                if(ch == ' ') {
                    ch = '.';
                }
                rows[dimensions.getNrOfRows() - (row + 1)] += ch;
                rows[dimensions.getNrOfRows() - (row + 1)] += ' ';
            }
        }
        addBottomLine(rows);
        addColumnNumbers(rows);
        return rows;
    }
}
