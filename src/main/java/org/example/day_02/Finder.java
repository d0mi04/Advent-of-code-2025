package org.example.day_02;

import org.example.shared.DataLine;

import java.util.stream.LongStream;

public class Finder {
    public static long solve(DataLine lines) {
        return lines.getLines().stream()
                .flatMapToLong(Finder::rangeToStream)
                .filter(Finder::isInvalid)
                .sum();
    }

    private static LongStream rangeToStream(String range) {
        long start = Long.parseLong(range.split("-")[0]);
        long end = Long.parseLong(range.split("-")[1]);
        return LongStream.rangeClosed(start, end); // it creates stream of numbers from given start and end
    }

    private static boolean isInvalid(long id) {
        String stringId = String.valueOf(id);
        if(stringId.length() % 2 != 0) {
            return false;
        }

        int half = stringId.length() / 2;
        return stringId.substring(0,half).equals(stringId.substring(half));
    }
}
