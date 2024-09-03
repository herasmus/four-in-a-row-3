package dk.htr.games.minmax.four_in_row.minimax;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;

import java.io.IOException;

public interface MiniMaxAlgorithm {
    int miniMax(long theBoard, int move, boolean isMaximising) throws GameException, IOException;
    long getNumberOfBoardsEvaluated();
}
