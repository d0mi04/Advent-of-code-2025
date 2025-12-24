package org.example.day_05;

import org.example.shared.DataSet;

public class Cafeteria {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/main/java/org/example/day_05/input.txt");

        howManyAreFresh(file);
    }

    private static void howManyAreFresh(DataSet file) {
        // * to zadanie to problem sprawdzania przynależności do przedziałów
        long resultPart1 = ManagementSystem.countFresh(file);
        System.out.println(resultPart1);

        // * to zadanie to problem znalezienia sumy długości unii przedziałów bez generowaia liczb
        long resultPart2 = ManagementSystem.countAllFreshPossible(file);
        System.out.println(resultPart2);
    }
}
