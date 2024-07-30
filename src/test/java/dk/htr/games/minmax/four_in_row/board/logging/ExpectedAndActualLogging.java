package dk.htr.games.minmax.four_in_row.board.logging;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExpectedAndActualLogging {
    private static Logger logger = LoggerFactory.getLogger(ExpectedAndActualLogging.class);

    public void logExpectedAndActualBoard(String message, long expected, long actual) {

    }

    public void logExpectedAndActualBoard(long expected, long actual) {
//        logExpectedAndActualBoard(null, expected, actual, LogLevel.INFO);
    }

  //  public static void logExpectedAndActualColumn(String message, int expected, int actual, LogLevel loglevel) {

//    }

    public static void logExpectedAndActualColumn(int expected, int actual) {
  //      logExpectedAndActualColumn(null, expected, actual, LogLevel.INFO);
    }

    public static void logExpectedAndActualBoardStrings(String[] expected, String[] actual) {
        logExpectedAndActualBoardStrings(null, expected, actual);
    }

    public static void logExpectedAndActualBoardStrings(String message, String[] expected, String[] actual) {
        if (message != null) {
            logger.error(message);
        }
        logger.error("Expected: ");
        logger.error("---------- ");
        for(String str : expected) {
            logger.error(str);
        }
        logger.error("");
        logger.error("Actual: ");
        logger.error("------- ");
        for(String str : actual) {
            logger.error(str);
        }

    }
}
