package dk.htr.games.minmax.four_in_row.board.render;

import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class BoardStateLogger {
    @Autowired
    private final BoardStateAsciiRenderer boardState;

    private static final Logger logger = LoggerFactory.getLogger(BoardStateLogger.class);

    public void logBoardStateTrace(long board) throws GameException {
        if(logger.isTraceEnabled()) {
            String[] boardStateStrings = boardState.getBoardStateAsciiImage(board);
            for(String str : boardStateStrings) {
                logger.trace(str);;
            }
        }
    }

    public void logBoardStateTrace(long board, Logger paramLogger) throws GameException {
        if(paramLogger.isTraceEnabled()) {
            String[] boardStateStrings = boardState.getBoardStateAsciiImage(board);

            for (String str : boardStateStrings) {
                paramLogger.trace(str);
                ;
            }
        }
    }

    public void logBoardStateTrace(char[][] board, Logger paramLogger) throws GameException {
        if(paramLogger.isTraceEnabled()) {
            String[] boardStateStrings = boardState.getBoardStateAsciiImage(board);

            for (String str : boardStateStrings) {
                paramLogger.trace(str);
            }
        }
    }

    public void logBoardStateDebug(char[][] board, Logger paramLogger) throws GameException {
        if(paramLogger.isDebugEnabled()) {
            String[] boardStateStrings = boardState.getBoardStateAsciiImage(board);

            for (String str : boardStateStrings) {
                paramLogger.debug(str);
            }
        }
    }

    public void logBoardStateWarn(long board) throws GameException {
        String[] boardStateStrings = boardState.getBoardStateAsciiImage(board);

        for(String str : boardStateStrings) {
            logger.warn(str);;
        }
    }

    public void logBoardStateTrace(char[][] board) throws GameException {
        if(logger.isTraceEnabled()) {
            String[] boardStateStrings = boardState.getBoardStateAsciiImage(board);
            for(String str : boardStateStrings) {
                logger.trace(str);;
            }
        }
    }

    public void logBoardStateWarn(char[][] board) throws GameException {
        String[] boardStateStrings = boardState.getBoardStateAsciiImage(board);

        for(String str : boardStateStrings) {
            logger.warn(str);;
        }
    }
}
