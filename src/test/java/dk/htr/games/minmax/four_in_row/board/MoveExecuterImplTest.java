package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.board.columns.four.FourRowColumnMoveExecutor;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MoveExecuterImplTest {
    final private MoveExecuterImpl moveExecuter;
    final private GameDimensions gameDimensions;

    public MoveExecuterImplTest() {
        this.gameDimensions = new GameDimensions(7, 6, 4);
        moveExecuter = new MoveExecuterImpl(new FourRowColumnMoveExecutor(), gameDimensions);
    }

    @CsvSource({
            "0x80808080808080, 1, 0x8080808080807E",
            "0x80808080807E80, 2, 0x80808080807C80",
            "0x808080807C8080, 3, 0x80808080788080",
            "0x80808078808080, 4, 0x808080C0808080",
            "0x80807980808080, 5, 0x8080C180808080",
            "0x807A8080808080, 6, 0x80C28080808080",
            "0x7B808080808080, 7, 0xC3808080808080"
    })
    @ParameterizedTest
    public void redMovesOneToSeven(long board, int move, long expected) throws GameException {
        long result = moveExecuter.moveRed(board, move);
        if(expected != result) {
            System.out.println("Move (1 based): " + move);
            System.out.println("input:       " + BinaryStringHelper.boardToBinaryString(board, ' '));
            System.out.println("Expected:    " + BinaryStringHelper.boardToBinaryString(expected, ' '));
            System.out.println("Result:      " + BinaryStringHelper.boardToBinaryString(result, ' '));
        }
        assertEquals(expected, result);
    }

    @CsvSource({
            "0x80808080808080, 1, 0x80808080808001",
            "0x80808080800180, 2, 0x80808080800380",
            "0x80808080038080, 3, 0x80808080078080",
            "0x80808007808080, 4, 0x808080CF808080",
            "0x80800480808080, 5, 0x8080CC80808080",
            "0x80028080808080, 6, 0x80068080808080",
            "0x06808080808080, 7, 0xCE808080808080"
    })
    @ParameterizedTest
    public void blueMovesOneToSeven(long board, int move, long expected) throws GameException {
        long result = moveExecuter.moveBlue(board, move);
        if(expected != result) {
            System.out.println("Move (1 based): " + move);
            System.out.println("input:       " + BinaryStringHelper.boardToBinaryString(board, ' '));
            System.out.println("Expected:    " + BinaryStringHelper.boardToBinaryString(expected, ' '));
            System.out.println("Result:      " + BinaryStringHelper.boardToBinaryString(result, ' '));
        }
        assertEquals(expected, result);
    }

    @Test
    public void redMovesLessThanOne() {
        GameException thrown = Assertions.assertThrows(GameException.class, () -> {
            moveExecuter.moveRed(80L, 0);
        });
        assertEquals("Move less than 1 not allowed", thrown.getMessage());
    }

    @Test
    public void redMovesGreaterThanNumberOfColumns() {
        GameException thrown = Assertions.assertThrows(GameException.class, () -> {
            moveExecuter.moveBlue(80L, gameDimensions.getNrOfColumns() + 1);
        });
        assertEquals("Move greater than " + gameDimensions.getNrOfColumns() + " not allowed", thrown.getMessage());
    }

    @Test
    public void blueMovesLessThanOne() {
        GameException thrown = Assertions.assertThrows(GameException.class, () -> {
            moveExecuter.moveRed(80L, 0);
        });
        assertEquals("Move less than 1 not allowed", thrown.getMessage());
    }

    @Test
    public void blueMovesGreaterThanNumberOfColumns() {
        GameException thrown = Assertions.assertThrows(GameException.class, () -> {
            moveExecuter.moveBlue(80L, gameDimensions.getNrOfColumns() + 1);
        });
        assertEquals("Move greater than " + gameDimensions.getNrOfColumns() + " not allowed", thrown.getMessage());
    }
}