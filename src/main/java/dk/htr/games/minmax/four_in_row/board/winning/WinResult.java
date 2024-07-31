package dk.htr.games.minmax.four_in_row.board.winning;

import dk.htr.games.minmax.four_in_row.board.Position;

public record WinResult(boolean hasWinner, int move, int[][] positions) {
}
