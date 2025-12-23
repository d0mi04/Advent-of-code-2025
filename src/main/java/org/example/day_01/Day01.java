package org.example.day_01;
import org.example.shared.DataSet;

public class Day01 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/main/java/org/example/day_01/input.txt");

        secretEntrance(file);
    }

    private static void secretEntrance(DataSet file) {
        Rotator rotatorPart1 = new Rotator(file);
        rotatorPart1.rotate("Part1");

        Rotator rotatorPart2 = new Rotator(file);
        rotatorPart2.rotate("Part2");
    }
}