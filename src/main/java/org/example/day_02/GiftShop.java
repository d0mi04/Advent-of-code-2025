package org.example.day_02;
import org.example.shared.DataLine;

public class GiftShop {
    public static void main(String[] args) {
        DataLine file = new DataLine("src/main/java/org/example/day_02/input.txt", ",");

        addAllInvalidIDs(file);
    }

    private static void addAllInvalidIDs(DataLine file) {
        long result = Finder.solve(file);
        System.out.println(result);
    }
}