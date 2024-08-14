package dk.htr.games.minmax.four_in_row.board.bits;

public class BinaryStringHelper {
    public static String columnToBinaryString(int column)  {
        String idBinaryString = Integer.toBinaryString(column);
        return String.format("%8s", idBinaryString).replace(' ', '0');
    }

    public static String boardToBinaryString(long board)  {
        String idBinaryString = Long.toBinaryString(board);
        return String.format("%64s", idBinaryString).replace(' ', '0');
    }

    public static String boardToBinaryString(long board, char seperator)  {
        String idBinaryString = Long.toBinaryString(board);
        String withLeadingZeros = String.format("%64s", idBinaryString).replace(' ', '0');
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            result.append(withLeadingZeros, i*8, (i+1) * 8);
            if(i < 7) result.append(seperator);
        }
        return result.toString();
    }
}
