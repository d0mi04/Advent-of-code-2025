package org.example.day_01;
import org.example.shared.DataSet;

public class Day01 {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/main/java/org/example/day_01/input.txt");

        Part1(file);
    }

    public static void Part1(DataSet file) {
        Rotator rotator = new Rotator(file);
        rotator.rotate();
    }
}