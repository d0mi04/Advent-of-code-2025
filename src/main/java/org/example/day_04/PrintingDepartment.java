package org.example.day_04;

import org.example.shared.DataSet;

public class PrintingDepartment {
    public static void main(String[] args) {
        DataSet file = new DataSet("src/main/java/org/example/day_04/input.txt");

        countAccessibleRolls(file);
    }

    public static void countAccessibleRolls(DataSet file) {
        int result = ForkliftFinder.countAccessible(file);
        System.out.println(result);
    }
}
