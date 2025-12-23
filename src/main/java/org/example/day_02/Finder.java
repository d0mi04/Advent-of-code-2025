package org.example.day_02;

import org.example.shared.DataLine;

import java.util.function.LongPredicate;
import java.util.stream.LongStream;

public class Finder {
    public static long solve(DataLine lines, LongPredicate invalidRule) {
        return lines.getLines().stream()
                .flatMapToLong(Finder::rangeToStream)
                .filter(invalidRule)
                .sum();
    }

    private static LongStream rangeToStream(String range) {
        long start = Long.parseLong(range.split("-")[0]);
        long end = Long.parseLong(range.split("-")[1]);
        return LongStream.rangeClosed(start, end); // it creates stream of numbers from given start and end
    }

    public static boolean isInvalidPatternAnyLength(long n) {
        String stringId = String.valueOf(n);
        int len = stringId.length();

        for (int patternLen = 1; patternLen <= len / 2; patternLen++) {
            if (len % patternLen != 0) continue;

            String pattern = stringId.substring(0, patternLen);
            int repeats = len / patternLen;

            if (repeats >= 2 && pattern.repeat(repeats).equals(stringId)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInvalidPatternTwice(long id) {
        String stringId = String.valueOf(id);
        if(stringId.length() % 2 != 0) {
            return false;
        }

        int half = stringId.length() / 2;
        return stringId.substring(0,half).equals(stringId.substring(half));
    }
}
