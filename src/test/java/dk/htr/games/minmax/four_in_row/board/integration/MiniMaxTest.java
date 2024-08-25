package dk.htr.games.minmax.four_in_row.board.integration;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.MoveExecuterImpl;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.columns.four.FourRowColumnMoveExecutor;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.board.winning.WinDetectorImpl;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import dk.htr.games.minmax.four_in_row.minimax.MemoryOptimizedMiniMax;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MiniMaxTest {
    private static final Logger logger = LoggerFactory.getLogger(MiniMaxTest.class);

    @Test
    public void dryRun() throws GameException {
        var dimensions = new GameDimensions(7, 4, 4);
        var columnUtility = new ColumnUtility(dimensions);
        var boardUtility = new BoardUtility(dimensions, columnUtility);
        var boardStateAsciiRenderer = new BoardStateAsciiRenderer(dimensions, boardUtility);
        var boardStateLogger = new BoardStateLogger(boardStateAsciiRenderer);
        var winDetector = new WinDetectorImpl(dimensions, columnUtility, boardStateLogger);
        var fourRowColumnMoveExecutor = new FourRowColumnMoveExecutor();
        var moveExecuter = new MoveExecuterImpl(fourRowColumnMoveExecutor, dimensions);
        var miniMax = new MemoryOptimizedMiniMax(dimensions, boardUtility, winDetector, moveExecuter);

        logger.info("Minimax dry-run: " );
        int res = miniMax.run();
        logger.info("Result: " + res);
    }
}
