package org.example.day_03;
import org.example.shared.DataSet;

public class Lobby {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/main/java/org/example/day_03/input.txt");

        findHighestJoltage(file);
    }

    private static void findHighestJoltage(DataSet file) {
        long resultPart1 = JoltageFinder.solve(file, 2);
        System.out.println(resultPart1);

        long resultPart2 = JoltageFinder.solve(file, 12);
        System.out.println(resultPart2);
    }
}