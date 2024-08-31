package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnMoveExecutor;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static dk.htr.games.minmax.four_in_row.board.bits.BitOperations.readByte;
import static dk.htr.games.minmax.four_in_row.board.bits.BitOperations.writeByte;

@RequiredArgsConstructor
@Component
public class MoveExecuterImpl implements MoveExecuter {
    final private ColumnMoveExecutor columnMoveExecutor;
    final private GameDimensions gameDimensions;

    private void checkMoveInRange(int move) throws GameException {
        if(move < 0) {
            throw new GameException("Move less than 0 not allowed");
        }
        if(move > (gameDimensions.getNrOfColumns() - 1)) {
            throw new GameException("Move greater than " + (gameDimensions.getNrOfColumns() - 1) + " not allowed");
        }
    }

    /**
     * @param move 0 based
     */
    @Override
    public long moveBlue(long presentBoard, int move) throws GameException {
        //checkMoveInRange(move);
        int columnBefore = readByte(presentBoard, move);
        int columnAfter = columnMoveExecutor.moveBlue(columnBefore);
        return writeByte(presentBoard, columnAfter, move);
    }

    @Override
    public long moveRed(long presentBoard, int move) throws GameException {
        //checkMoveInRange(move);
        int columnBefore = readByte(presentBoard, move);
        int columnAfter = columnMoveExecutor.moveRed(columnBefore);
        return writeByte(presentBoard, columnAfter, move);
    }
}
