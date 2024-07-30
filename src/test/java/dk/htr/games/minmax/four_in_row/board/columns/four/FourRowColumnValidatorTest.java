package dk.htr.games.minmax.four_in_row.board.columns.four;

import dk.htr.games.minmax.four_in_row.board.columns.FourRowColumnStreams;
import dk.htr.games.minmax.four_in_row.exceptions.BoardStateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FourRowColumnValidatorTest {
    FourRowColumnValidator validator = new FourRowColumnValidator();

    public static IntStream validColumnStream() {
        return FourRowColumnStreams.validColumnStream();
    }

    public static IntStream invalidColumnStream() {
        return FourRowColumnStreams.invalidColumnStream();
    }

    @Test
    public void outOfBoundsLessThanZero() {
        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            validator.isValidColumn(-1);
        }, "BoardStateException was expected");

        Assertions.assertEquals("Column state cant be less than 0x00", thrown.getMessage());
    }

    @Test
    public void outOfBoundsMoreThan0xFF() {
        BoardStateException thrown = Assertions.assertThrows(BoardStateException.class, () -> {
            validator.isValidColumn(0x100);
        }, "BoardStateException was expected");

        Assertions.assertEquals("Column state cant be greater than 0xFF", thrown.getMessage());
    }

    @ParameterizedTest
    @MethodSource("validColumnStream")
    public void validColumn4Rows(int column) throws BoardStateException {
        assertTrue(validator.isValidColumn(column));
    }

    @ParameterizedTest
    @MethodSource("invalidColumnStream")
    public void invalidColumn4Rows(int column) throws BoardStateException {
        assertFalse(validator.isValidColumn(column));
    }
}
