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

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Setter
@Getter
@SpringBootApplication
public class FourInARowGame implements ApplicationRunner {
	static Logger logger = LoggerFactory.getLogger(FourInARowGame.class);
	//private NInARowGame nInARowGame;
	private final GameDimensions gameDimensions;
	private final MemoryOptimizedMiniMax miniMaxAlgorithm;
	private final BoardUtility boardUtility;

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(FourInARowGame.class);
		application.setWebApplicationType(WebApplicationType.NONE);
		application.run(args);
	}

	private String getTimeStamp() {

		// Get the current Instant
		Instant now = Instant.now();

		// Convert the Instant to LocalDateTime
		LocalDateTime dateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());

		// Format the LocalDateTime to a readable format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
		return dateTime.format(formatter);
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
		System.out.println("FourInARowGame run: " + getTimeStamp());
		System.out.println("Dimensions: " + gameDimensions.getNrOfColumns());
		var initialBoard = boardUtility.createInitialBoard();
		long startTime = System.nanoTime();
		int res = miniMaxAlgorithm.miniMax(initialBoard, -1, true);
		long endTime = System.nanoTime();
		long elapsedTime = endTime - startTime;
		// Convert to milliseconds if needed
		double elapsedTimeInMillis = elapsedTime / 1_000_000.0;

		// Print the execution time
		System.out.println("Elapsed time in nanoseconds: " + elapsedTime);
		System.out.println("Elapsed time in milliseconds: " + elapsedTimeInMillis);
		System.out.println("FourInARowGame: " + res);
/*
		res = miniMaxAlgorithm.miniMax(initialBoard, -1, true);
		endTime = System.nanoTime();
		// Convert to milliseconds if needed
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		// Convert to milliseconds if needed
		elapsedTimeInMillis = elapsedTime / 1_000_000.0;

		// Print the execution time
		logger.error("Elapsed time in nanoseconds: " + elapsedTime);
		logger.error("Elapsed time in milliseconds: " + elapsedTimeInMillis);
*/
		System.out.println("Number of boards evaluated: " + miniMaxAlgorithm.getNumberOfBoardsEvaluated());
		System.out.println("Number of winning boards:   " + miniMaxAlgorithm.getNumberOfWinningBoardsAI());

		System.out.println("FourInARowGame: " + res);

	}
}
