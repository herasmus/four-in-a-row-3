package dk.htr.games.minmax.four_in_row.minimax;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;

public interface MiniMaxAlgorithm {
    int miniMax(long theBoard, int move, boolean isMaximising) throws GameException;
    long getNumberOfBoardsEvaluated();
}
