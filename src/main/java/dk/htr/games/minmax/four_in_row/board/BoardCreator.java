package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.config.GameDimensions;

public class BoardCreator {
    public static char[][] createInitialBoard(GameDimensions dimensions) {
        return null;
    }

    public static char[][] createBoard(String[] columns) {
        char[][] board = new char[columns.length][];
        for(int column = 0; column < columns.length; column++) {
            board[column] = columns[column].toCharArray();
        }
        return board;
    }
}
