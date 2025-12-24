package org.example.day_05;

import org.example.shared.DataSet;

import java.util.List;

public class ManagementSystem {
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
