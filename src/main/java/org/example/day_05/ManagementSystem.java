package org.example.day_05;

import org.example.shared.DataSet;

import java.util.Comparator;
import java.util.List;

public class ManagementSystem {
    public static long countAllFreshPossible(DataSet file) {
        // 1. posortować przedziały względem początków
        var lines = file.getLines();
        var blankLineIndex = lines.indexOf("");

        var ranges = lines.subList(0, blankLineIndex).stream()
                .map(ManagementSystem::parseRanges)
                .sorted(Comparator.comparing(Range::start)) // względem początku
                .toList();

        long allFreshPossible = 0;

        // 2. scalanie
        long currentStart = ranges.getFirst().start();
        long currentEnd = ranges.getFirst().end();

        for(Range range : ranges) {
            if(range.start() <= currentEnd + 1) {
                // jeśli przedział na siebie nachodzi
                currentEnd = Math.max(currentEnd, range.end());
            } else {
                allFreshPossible += currentEnd - currentStart + 1;
                currentStart = range.start();
                currentEnd = range.end();
            }
        }
        // ostatni przedział
        allFreshPossible += currentEnd - currentStart + 1;

        return allFreshPossible;
    }

    public static long countFresh(DataSet file) {
        // 1. podzielić input na ranges i IDs
        var lines = file.getLines();
        int blankLineIndex = lines.indexOf("");

        // 1.1 ranges
        var ranges = lines.subList(0, blankLineIndex).stream()
                .map(ManagementSystem::parseRanges)
                .toList();

        // 1.2. IDs
        return lines.subList(blankLineIndex + 1, lines.size()).stream()
                .mapToLong(Long::parseLong)
                .filter(id -> isFresh(id, ranges)) // 3. sprawdzać, czy ID należy do jakiegoś przedziału
                .count(); // 4. count() bo liczymy ile ID należy do przedziałów
    }

    private static Range parseRanges(String line) {
        String[] parts = line.split("-");
        return new Range(
                Long.parseLong(parts[0]), Long.parseLong(parts[1])
        );
    }

    // 3. sprawdzanie przynależności do przedziału
    private static boolean isFresh(long id, List<Range> ranges) {
        return ranges.stream().anyMatch(r -> r.contains(id)); // contains to ta metoda którą stworzyłam w Range
    }
}
