package com.hourly.util;

import java.math.BigInteger;

/**
 * Used to convert the underlying long identifiers into more random-looking
 * radix 62 identifiers.
 */
public class IdConverter {

    /**
     * The id pattern that results from this converter. Ids within URLs should use this pattern.
     */
    public static final String PATTERN = "[a-zA-Z0-9]{12,15}";

    private static final int MAX_BITS = 72;
    private static final long HIGH_BIT = 1L << 63;
    private static final BigInteger[] BIT_POSITIONS;

    /**
     * DON'T EVER change this value!
     */
    private static final BigInteger XOR = new BigInteger(new byte[] { (byte) 0x63, (byte) 0xd1, (byte) 0xa5,
        (byte) 0xcf, (byte) 0x8e, (byte) 0xb2, (byte) 0x17, (byte) 0xe4, (byte) 0xf8, (byte) 0x9c });

    /**
     * DON'T EVER change this array! It defines how the ids are mangled.
     */
    private static final int[] BIT_ORDER = new int[] { 70, 59, 4, 30, 63, 49, 18, 69, 21, 58, 35, 28, 12, 51, 66, 53,
        20, 17, 62, 8, 71, 19, 44, 26, 7, 61, 25, 29, 42, 6, 34, 15, 54, 57, 67, 16, 37, 45, 9, 47, 33, 31, 40, 11,
        43, 68, 32, 22, 23, 36, 14, 24, 48, 10, 46, 39, 60, 5, 50, 65, 41, 38, 55, 27, 2, 56, 52, 3, 13, 1, 64, 0 };

    static {
        BIT_POSITIONS = new BigInteger[MAX_BITS];
        for (int i = 0; i < MAX_BITS; i++) {
            BIT_POSITIONS[i] = BigInteger.ONE.shiftLeft(i);
        }
    }

    /**
     * Converts the model identifiers from long to a radix 36 string.
     */
    public static String fromId(long id) {

        // Set up the big int
        BigInteger bigId;
        boolean neg = (id & HIGH_BIT) != 0;
        if (neg) {
            bigId = BigInteger.valueOf(id & ~HIGH_BIT);
            bigId = bigId.setBit(63);
        } else {
            bigId = BigInteger.valueOf(id);
        }

        // Shuffle the bits in the id.
        bigId = bigId.xor(XOR);
        BigInteger out = BigInteger.ZERO;
        for (int i = 0; i < BIT_ORDER.length; i++) {
            BigInteger posSource = BIT_POSITIONS[BIT_ORDER[i]];
            BigInteger posDest = BIT_POSITIONS[i];
            out = out.or(posSource.and(bigId).equals(BigInteger.ZERO) ? BigInteger.ZERO : posDest);
        }

        //       out = out.xor(OUT_XOR);
        return Base62.encode(out);
    }

    /**
     * Converts the model identifiers from a radix 36 string to a long.
     */
    public static long toId(String id) {
        if (id == null) {
            return 0;
        }

        // Convert the string to a long and extract the seed from the top.
        // Then un-XOR the result.
        BigInteger in = Base62.decodeToBigInteger(id);
        //       in = in.xor(OUT_XOR);

        // Unshuffle the resulting bits.
        BigInteger out = BigInteger.ZERO;
        for (int i = 0; i < BIT_ORDER.length; i++) {
            BigInteger posDest = BIT_POSITIONS[BIT_ORDER[i]];
            BigInteger posSource = BIT_POSITIONS[i];
            out = out.or(posSource.and(in).equals(BigInteger.ZERO) ? BigInteger.ZERO : posDest);
        }

        out = out.xor(XOR);
        return out.longValue();
    }
}