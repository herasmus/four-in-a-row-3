package dk.htr.games.minmax.four_in_row.board.bits;

import dk.htr.games.minmax.four_in_row.exceptions.BitException;

public class BitOperations {
    public static long[] ERASE_BYTE_MASK = new long[7];

    static {
        ERASE_BYTE_MASK[0] = 0xFF_FF_FF_FF_FF_FF_00L;
        ERASE_BYTE_MASK[1] = 0xFF_FF_FF_FF_FF_00_FFL;
        ERASE_BYTE_MASK[2] = 0xFF_FF_FF_FF_00_FF_FFL;
        ERASE_BYTE_MASK[3] = 0xFF_FF_FF_00_FF_FF_FFL;
        ERASE_BYTE_MASK[4] = 0xFF_FF_00_FF_FF_FF_FFL;
        ERASE_BYTE_MASK[5] = 0xFF_00_FF_FF_FF_FF_FFL;
        ERASE_BYTE_MASK[6] = 0x00_FF_FF_FF_FF_FF_FFL;
    }

    // Create a mask: Shiftamount 3 => 0000 0111
    public static int getNTimesOneRightMask(int shiftAmount) {
        return (1 << shiftAmount) - 1;
    }

    public static int getBit(int input, int bitPos) {
        int mask = 1 << (bitPos - 1);
        int value = input & mask;
        return value >> (bitPos - 1);
    }

    public static int turnOn(int input, int bitPos) {
        int mask = 1 << (bitPos - 1);
        return input | mask;
    }

    protected static int turnOff(int input, int bitPos) {
        int mask = 1 << (bitPos - 1);
        int invertedMask = ~mask;
        return input & invertedMask;
    }

    public static int setBit(int input, int bitPos, int value) throws BitException {
        return switch (value) {
            case 0 -> turnOff(input, bitPos);
            case 1 -> turnOn(input, bitPos);
            default -> throw new BitException("Value out of range for a bit");
        };
    }

    public static int readByte(long input, int byteNr) {
        long rightShifted = input >> (byteNr * 8);
        return (int)(rightShifted & 0b11111111);
    }

    public static long writeByte(long input, int columnValue, int byteNr) {
        int nfOfBitsToShift = byteNr * 8;
        long leftShifted = (long) columnValue << nfOfBitsToShift;
        input = input & ERASE_BYTE_MASK[byteNr];
        return input | leftShifted;
    }
}
