package dk.htr.games.minmax.four_in_row.board.columns;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FourRowColumnStreams {
    public static IntStream validColumnStream() {
        var s1 = IntStream.range(0x01, 0x07); // Generates values from 0b00000001 to 0b00000111
        var s2 = IntStream.range(0x78, 0x7E); // Generates values from 0b01111000 to 0b01111110
        var s3 = IntStream.of(0x80);       // Stream of 0b10000000
        var s4 = IntStream.range(0xC0, 0xCF); // Generates values from 0b11010000 to 0b11111111
        return Stream.of(s1, s2, s3, s4).flatMapToInt(s -> s);
    }

    public static IntStream invalidColumnStream() {
        var s1 = IntStream.of(0x00);       // Stream of 0b00000000
        var s2 = IntStream.range(0x08, 0x77); // Generates values from 0b00001000 to 0b01110111
        var s3 = IntStream.of(0x7F);       // Stream of 0b01111111
        var s4 = IntStream.range(0x81, 0xBF); // Generates values from 0b01111000 to 0b01111110
        var s5 = IntStream.range(0xD0, 0xFF); // Generates values from 0b11010000 to 0b11111111
        return Stream.of(s1, s2, s3, s4, s5).flatMapToInt(s -> s);
    }
}
