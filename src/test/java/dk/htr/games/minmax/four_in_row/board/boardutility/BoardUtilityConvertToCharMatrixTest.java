package dk.htr.games.minmax.four_in_row.board.boardutility;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static dk.htr.games.minmax.four_in_row.board.columns.four.ColumnStrings.*;
import static org.junit.jupiter.api.Assertions.*;

public class BoardUtilityConvertToCharMatrixTest {
    Logger logger = LoggerFactory.getLogger(BoardUtilityConvertToCharMatrixTest.class);

    // 2x4x3 board
    final static GameDimensions gameDim2x4x3 = new GameDimensions(2, 4, 3);

    // 5x4x3 board
    final static GameDimensions gameDim5x4x3 = new GameDimensions(5, 4, 3);

    @Test
    public void convertToCharMatrix_2Columns4Rows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim2x4x3);
        BoardUtility boardUtility = new BoardUtility(gameDim2x4x3, columnUtility);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim2x4x3, boardUtility);

        final long board = 0b11000101_00000011L;
        char[][] result = boardUtility.convertToCharMatrix(board);
        char[][] expected = {
                { X, X, E, E},
                { X, O, X, O}};
        assertArrayEquals(expected, result);
    }

    @Test
    public void convertToCharMatrix_5Columns4Rows() throws GameException {
        ColumnUtility columnUtility = new ColumnUtility(gameDim5x4x3);
        BoardUtility boardUtility = new BoardUtility(gameDim5x4x3, columnUtility);
        BoardStateAsciiRenderer boardState = new BoardStateAsciiRenderer(gameDim5x4x3, boardUtility);
        final long board = 0b00000010_00000001_11001001_00000100_11001101L;
        char[][] result = boardUtility.convertToCharMatrix(board);
        char[][] expected = {
                { X, O, X, X},
                { O, O, X, E},
                { X, O, O, X},
                { X, E, E, E},
                { O, X, E, E},

        };
        if(!Arrays.equals(expected, result)) {
            for(int i = 0; i < expected.length; i++) {
                logger.error("Expected: " + Arrays.toString(expected[i]));
                logger.error("Actual:   " + Arrays.toString(result[i]));
            }
        }
        assertArrayEquals(expected, result);
    }
}
