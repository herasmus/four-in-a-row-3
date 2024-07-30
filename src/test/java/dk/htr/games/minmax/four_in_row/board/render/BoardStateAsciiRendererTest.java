package dk.htr.games.minmax.four_in_row.board.render;

import dk.htr.games.minmax.four_in_row.board.BoardCreator;
import dk.htr.games.minmax.four_in_row.board.columns.ColumnStringOperations;
import dk.htr.games.minmax.four_in_row.board.winning.WinDetectorImpl;
import dk.htr.games.minmax.four_in_row.config.GameDimensions;
import dk.htr.games.minmax.four_in_row.exceptions.GameException;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static dk.htr.games.minmax.four_in_row.board.logging.ExpectedAndActualLogging.logExpectedAndActualBoardStrings;
import static org.junit.jupiter.api.Assertions.*;

public class BoardStateAsciiRendererTest {
    Logger logger = LoggerFactory.getLogger(BoardStateAsciiRendererTest.class);

    GameDimensions gameDim7x4x4 = new GameDimensions(7, 4, 4);
    ColumnStringOperations columnOperations7x4x4 = new ColumnStringOperations(gameDim7x4x4);

    GameDimensions gameDim7x6x4 = new GameDimensions(7, 6, 4);
    ColumnStringOperations columnOperations7x6x4 = new ColumnStringOperations(gameDim7x6x4);


    /*
     *  Example: 7 x 6
     *
     *  If the column isn't full, then bit 7 and 6,
     *  and all of the bits of same value in bit 5 and below
     *  (until another bitvalue is encountered) to be considered as empty counters
     *  denoted by a '.'
     *  1 = 'x'
     *  0 = 'o'
     *
     */
    //@Test
    public void getBoardStateString_compact_7x6() throws GameException {
        var renderer = new BoardStateAsciiRenderer(gameDim7x6x4, columnOperations7x6x4);

        final long board = 0b01111010_10000000_11001101_00001111_01111000_01110110_11101001L;
        String[] actualStrings = renderer.getBoardStateAsciiImage(board);
        assertEquals(gameDim7x6x4.getNrOfRows() + 2, actualStrings.length);

        String[] expectedLines = {
        " 6| x . . . o . . ",
        " 5| o . . . o . . ",
        " 4| x o . x x . . ",
        " 3| o x o x x . o ",
        " 2| o x o x o . x ",
        " 1| x o o x x . o ",
        " -----------------",
        "    1 2 3 4 5 6 7 "
        };

        if(!Arrays.equals(expectedLines, actualStrings)) {
            logExpectedAndActualBoardStrings(expectedLines, actualStrings);
        }

        assertEquals(expectedLines[0], actualStrings[0]);
        assertEquals(expectedLines[1], actualStrings[1]);
        assertEquals(expectedLines[2], actualStrings[2]);
        assertEquals(expectedLines[3], actualStrings[3]);
        assertEquals(expectedLines[4], actualStrings[4]);
        assertEquals(expectedLines[5], actualStrings[5]);
        assertEquals(expectedLines[6], actualStrings[6]);
        assertEquals(expectedLines[7], actualStrings[7]);
    }

    //@Test
    public void getBoardStateString_compact_7x4() throws GameException {
        var renderer = new BoardStateAsciiRenderer(gameDim7x4x4, columnOperations7x4x4);

        final long board = 0b01111110_00000111_11000011_00000010_10000000_01111101_11001010L;
        String[] actualStrings = renderer.getBoardStateAsciiImage(board);
        assertEquals(gameDim7x4x4.getNrOfRows() + 2, actualStrings.length);
        String[] expectedLines = {
        " 4| x . . . o . . ",
        " 3| o . . . o x . ",
        " 2| x o . x x x . ",
        " 1| o x . o x x o ",
        " -----------------",
        "    1 2 3 4 5 6 7 ",
        };

        if(!Arrays.equals(expectedLines, actualStrings)) {
            logExpectedAndActualBoardStrings(expectedLines, actualStrings);
        }

        assertEquals(expectedLines[0], actualStrings[0]);
        assertEquals(expectedLines[1], actualStrings[1]);
        assertEquals(expectedLines[2], actualStrings[2]);
        assertEquals(expectedLines[3], actualStrings[3]);
        assertEquals(expectedLines[4], actualStrings[4]);
        assertEquals(expectedLines[5], actualStrings[5]);
    }

    String boardStateString_7x6[] =
            { "XOOXOO",
                    "XXOO  ",
                    "      ",
                    "XXOX  ",
                    "OXO   ",
                    "X     ",
                    "OXOOXX  " };

    String[] expectedResult_BoardStateString_7x6 = {
            " 6| x . . . o . . ",
            " 5| o . . . o . . ",
            " 4| x o . x x . . ",
            " 3| o x o x x . o ",
            " 2| o x o x o . x ",
            " 1| x o o x x . o ",
            " -----------------",
            "    1 2 3 4 5 6 7 "
    };

    @Test
    public void getBoardStateString_7x6() throws GameException {
        var dimensions = new GameDimensions(7, 6, 4);
        WinDetectorImpl winDetector = new WinDetectorImpl(dimensions);
        char[][] board = BoardCreator.createBoard(boardStateString_7x6);

        var columnStringOperations = new ColumnStringOperations(dimensions);
        var renderer = new BoardStateAsciiRenderer(dimensions, columnStringOperations);
        String[] result = renderer.getBoardStateAsciiImage(board);

        var boardStateLogger = new BoardStateLogger(renderer);
        // Just for visual info
        boardStateLogger.logBoardStateWarn(board);

        if(!Arrays.equals(expectedResult_BoardStateString_7x6, result)) {
            logExpectedAndActualBoardStrings(expectedResult_BoardStateString_7x6, result);
        }

        assertEquals(expectedResult_BoardStateString_7x6[0], result[0]);
        assertEquals(expectedResult_BoardStateString_7x6[1], result[1]);
        assertEquals(expectedResult_BoardStateString_7x6[2], result[2]);
        assertEquals(expectedResult_BoardStateString_7x6[3], result[3]);
        assertEquals(expectedResult_BoardStateString_7x6[4], result[4]);
        assertEquals(expectedResult_BoardStateString_7x6[5], result[5]);
        assertEquals(expectedResult_BoardStateString_7x6[6], result[6]);
        assertEquals(expectedResult_BoardStateString_7x6[7], result[7]);
    }
}
