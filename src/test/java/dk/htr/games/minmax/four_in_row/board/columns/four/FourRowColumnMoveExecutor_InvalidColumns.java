package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.FourRowColumnStreams;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class FourRowColumnMoveExecutor_InvalidColumns {
    private final Logger logger = LoggerFactory.getLogger(FourRowColumnMoveExecutor_InvalidColumns.class);
    FourRowColumnMoveExecutor columnMoveExecutor = new FourRowColumnMoveExecutor();

    public static IntStream invalidColumnStream() {
        return FourRowColumnStreams.invalidColumnStream();
    }

    @ParameterizedTest
    @MethodSource("invalidColumnStream")
    public void illegalColumnHandlingRedMove(int column) {
        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            columnMoveExecutor.moveRed(column);
        }, "BoardStateException was expected");
        Assertions.assertEquals("Invalid column " + column, thrown.getMessage());
    }

    @ParameterizedTest
    @MethodSource("invalidColumnStream")
    public void illegalColumnHandlingBlueMove(int column) {
        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            columnMoveExecutor.moveBlue(column);
        }, "BoardStateException was expected");
        Assertions.assertEquals("Invalid column " + column, thrown.getMessage());
    }
}
