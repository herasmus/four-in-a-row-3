package dk.htr.games.minmax.four_in_row.board;

import dk.htr.games.minmax.four_in_row.board.columns.ColumnMoveExecutor;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MoveExecuterImpl implements MoveExecuter {
    final private ColumnMoveExecutor columnMoveExecutor;
    final private GameDimensions gameDimensions;

    private void checkMoveInRange(int move) throws GameException {
        if(move < 1) {
            throw new GameException("Move less than 1 not allowed");
        }
        if(move > gameDimensions.getNrOfColumns()) {
            throw new GameException("Move greater than " + gameDimensions.getNrOfColumns() + " not allowed");
        }
    }

    /**
     * @param move 1 based in domain, 0 based in implementation. Change?
     */
    @Override
    public long moveBlue(long presentBoard, int move) throws GameException {
        checkMoveInRange(move);

   //     int columnBefore = readByte(presentBoard, move-1);
   //     int columnAfter = columnMoveExecutor.moveBlue(columnBefore);
     //   return writeByte(presentBoard, columnAfter, move - 1);
        return 0;
    }

    @Override
    public long moveRed(long presentBoard, int move) throws GameException {
/*        checkMoveInRange(move);
        int columnBefore = readByte(presentBoard, move-1);
        int columnAfter = columnMoveExecutor.moveRed(columnBefore);
        return writeByte(presentBoard, columnAfter, move - 1);*/
        return 0;
    }
}
