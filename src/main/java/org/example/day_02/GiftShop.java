package org.example.day_02;
import org.example.shared.DataLine;

public class GiftShop {
    public static void main(String[] args) {
        DataLine file = new DataLine("src/main/java/org/example/day_02/input.txt", ",");

        addAllInvalidIDs(file);
    }

    private static void addAllInvalidIDs(DataLine file) {
        long resultPart1 = Finder.solve(file, Finder::isInvalidPatternTwice);
        System.out.println(resultPart1);

        long resultPart2 = Finder.solve(file, Finder::isInvalidPatternAnyLength);
        System.out.println(resultPart2);
    }
}