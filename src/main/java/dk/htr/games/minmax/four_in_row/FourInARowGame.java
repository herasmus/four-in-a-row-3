package dk.htr.games.minmax.four_in_row;

import dk.htr.games.minmax.four_in_row.board.BoardUtility;
import dk.htr.games.minmax.four_in_row.board.MoveExecuterImpl;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnUtility;
import dk.htr.games.minmax.four_in_row.board.columns.four.FourRowColumnMoveExecutor;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateAsciiRenderer;
import dk.htr.games.minmax.four_in_row.board.render.BoardStateLogger;
import dk.htr.games.minmax.four_in_row.board.winning.WinDetectorImpl;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.minimax.MemoryOptimizedMiniMax;
import dk.htr.games.minmax.four_in_row.minimax.MiniMaxAlgorithm;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@Setter
@Getter
@SpringBootApplication
public class FourInARowGame implements ApplicationRunner {
	static Logger logger = LoggerFactory.getLogger(FourInARowGame.class);
	//private NInARowGame nInARowGame;
	private final GameDimensions gameDimensions;
	private final MiniMaxAlgorithm miniMaxAlgorithm;
	private final BoardUtility boardUtility;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(FourInARowGame.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/*
		var dimensions = new GameDimensions(7, 4, 4);
		var columnUtility = new ColumnUtility(dimensions);
		var boardUtility = new BoardUtility(dimensions, columnUtility);
		var boardStateAsciiRenderer = new BoardStateAsciiRenderer(dimensions, boardUtility);
		var boardStateLogger = new BoardStateLogger(boardStateAsciiRenderer);
		var winDetector = new WinDetectorImpl(dimensions, columnUtility, boardStateLogger);
		var fourRowColumnMoveExecutor = new FourRowColumnMoveExecutor();
		var moveExecuter = new MoveExecuterImpl(fourRowColumnMoveExecutor, dimensions);
		var miniMax = new MemoryOptimizedMiniMax(dimensions, boardUtility, winDetector, moveExecuter);
*/
		logger.info("FourInARowGame run: " );
		var initialBoard = boardUtility.createInitialBoard();
		int res = miniMaxAlgorithm.miniMax(initialBoard, -1, true);
		logger.info("FourInARowGame: " + res);
	}
}
