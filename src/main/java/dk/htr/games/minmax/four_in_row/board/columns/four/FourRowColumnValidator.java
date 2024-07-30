package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnValidator;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;

public class FourRowColumnValidator implements ColumnValidator {
    protected final static boolean[] fourRows = new boolean[256];
    static {
        initFourRows();
    }

    private static void initFourRows() {
        int total = 0;
        fourRows[0b00000000] = false;
        total++;

        for(int i = 0b00000001; i <= 0b00000111; i++) {
            fourRows[i] = true;
            total++;
        }

        for(int i = 0b00001000; i <= 0b00001111; i++) {
            fourRows[i] = false;
            total++;
        }

        for(int i = 0b00010000; i <= 0b00011111; i++) {
            fourRows[i] = false;
            total++;
        }

        for(int i = 0b00100000; i <= 0b00111111; i++) {
            fourRows[i] = false;
            total++;
        }

        for(int i = 0b01000000; i <= 0b01110111; i++) {
            fourRows[i] = false;
            total++;
        }

        for(int i = 0b01111000; i <= 0b01111110; i++) {
            fourRows[i] = true;
            total++;
        }
        fourRows[0b01111111] = false;
        total++;
        // Empty
        fourRows[0b10000000] = true;
        total++;
        for(int i = 0b10000001; i <= 0b10111111; i++) {
            fourRows[i] = false;
            total++;
        }
        for(int i = 0b11000000; i <= 0b11001111; i++) {
            fourRows[i] = true;
            total++;
        }
        for(int i = 0b11010000; i <= 0b11111111; i++) {
            fourRows[i] = false;
            total++;
        }

        if(total != 256) throw new RuntimeException("Fatal error in initialization");
    }

    public boolean isValidColumn(int column) throws BoardStateException {
        if((column < 0)) throw new BoardStateException("Column state cant be less than 0x00");
        if((column > 255)) throw new BoardStateException("Column state cant be greater than 0xFF");
        return fourRows[column];
    }
}
