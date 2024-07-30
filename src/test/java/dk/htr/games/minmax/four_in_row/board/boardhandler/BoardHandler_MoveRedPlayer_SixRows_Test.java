package dk.htr.games.minmax.four_in_row.board.boardhandler;

import dk.htr.games.minmax.four_in_row.board.BoardHandler;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardHandler_MoveRedPlayer_SixRows_Test {
    // 2x4x3 board
    GameDimensions gameDim2x4x3 = new GameDimensions(2, 4, 3);
    ColumnStringOperations columnOperations2x4x3 = new ColumnStringOperations(gameDim2x4x3);

    // 6x4x3 board
    GameDimensions gameDim6x4x3 = new GameDimensions(6, 4, 3);
    ColumnStringOperations columnOperations6x4x3 = new ColumnStringOperations(gameDim6x4x3);

    // 7x6x3 board
    GameDimensions gameDim7x6x3 = new GameDimensions(7, 6, 3);
    ColumnStringOperations columnOperations7x6x3 = new ColumnStringOperations(gameDim7x6x3);

    // 7x6x4 board
    GameDimensions gameDim7x6x4 = new GameDimensions(7, 6, 4);
    ColumnStringOperations columnOperations7x6x4 = new ColumnStringOperations(gameDim7x6x4);
/*
    @Test
    public void emptyColumn_7x6x3() throws GameException {
        BoardHandler boardHandler = new BoardHandler(gameDim7x6x3, columnOperations7x6x3);

        int expected = 0b01111110;
        int result   = boardHandler.moveColumn(0b10000000, false);
        assertEquals(expected, result);
    }

    @Test
    public void emptyColumn_6x4x3() throws GameException {
        BoardHandler boardHandler = new BoardHandler(gameDim6x4x3, columnOperations6x4x3);
        int expected = 0b01111110;
        int result   = boardHandler.moveColumn(0b10000000, false);
        assertEquals(expected, result);
    }

    @Test
    public void roomFourOne_6x4x3() throws GameException {
        BoardHandler boardHandler = new BoardHandler(gameDim6x4x3, columnOperations6x4x3);
        int expected = 0b11000010;
        int result   = boardHandler.moveColumn(0b01111010, false);

        assertEquals(expected, result);
    }

    @Test
    public void roomFourOne_7x6x4() throws GameException {
        BoardHandler boardHandler = new BoardHandler(gameDim7x6x4, columnOperations7x6x4);
        int expected = 0b11011010;
        int result = boardHandler.moveColumn(0b00011010, false);
        assertEquals(expected, result);

    }

    @Test
    public void roomFourOne_2x4x3() throws GameException {
        BoardHandler boardHandler = new BoardHandler(gameDim2x4x3, columnOperations2x4x3);
        int expected = 0b11000010;
        int result   = boardHandler.moveColumn(0b01111010, false);

        assertEquals(expected, result);
    }*/
}
