package dk.htr.games.minmax.four_in_row.board.boardhandler;

public class BoardHandlerHelperMethodsTest {
    /*
     *  5 x 4 board
     * -------------
     *
     *                           x
     *                           x                               o
     *                           o                               x
     *                           x               o       x       o
     *                  ---------------------------------------------------
     *                   Column: 1       2       3       4       5
     */
/*    @Test
    public void someAvailableSlots() {
        BoardHandler.setGameSettings(new GameDimensions(5, 4, 3));
        final long expectedID = 0b00111010_00000001_00111110_10000000_01001101L;
        byte res = BoardHandler.getAvailableSlots(expectedID);
        byte expected = 0b00011110;

        assertEquals(expected, res);
    }
*/
    /*
     *  5 x 4 board
     * -------------
     *
     *
     *                           x                               o
     *                           o                               x
     *                           x               o       x       o
     *                  ---------------------------------------------------
     *                   Column: 1       2       3       4       5
     */
  /*  @Test
    public void maxAvailableSlots() {
        BoardHandler.setGameSettings(new GameDimensions(5, 4, 3));
        final long expectedID = 0b00111010_00000001_00111110_10000000_00000101L;
        byte res = BoardHandler.getAvailableSlots(expectedID);
        byte expected = 0b00011111;

        assertEquals(expected, res);
    }*/
}
