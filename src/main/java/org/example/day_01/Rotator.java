package org.example.day_01;

import org.example.shared.DataSet;

import java.util.ArrayList;

public class Rotator {
    int currentPos;
    ArrayList<String> rotations;

    public Rotator(DataSet input) {
        this.rotations = new ArrayList<>(input.getLines());
        this.currentPos = 50;
    }

    public void rotate(String part) {
        int password = 0;
        int prevPos = currentPos;
        for(String rotation : rotations) {
            char dir = rotation.charAt(0); // direction is the first letter in line
            int value = Integer.parseInt(rotation.substring(1)); // the rest is value to rotate
            if(checkDirection(dir)) {
                // if dir = 'R'
                currentPos = prevPos + value;
            } else {
                // if dir = 'L'
                currentPos = prevPos - value;
            }

            if(part.equals("Part1")) {
                if((currentPos % 100) == 0) { // checking when current position is set to 0
                    password ++;
                }
            }

            if(part.equals("Part2")) {
                password += countClicks(currentPos, prevPos);
            }

            prevPos = currentPos;
//            System.out.println("Rotated: " + rotation + " Current position: " + currentPos + " password: " + password);
        }
        System.out.println("Password: " + password);
    }

    public int countClicks(int currentPos, int prevPos) {
        if (prevPos == currentPos) return 0;

        int min = Math.min(prevPos, currentPos);
        int max = Math.max(prevPos, currentPos);

        // we count how many segments we are passing from prevPos to currentPos, min < k*100 <= max
        int first = Math.floorDiv(min + 99, 100) * 100;
        int last  = Math.floorDiv(max, 100) * 100;

        if (first > last) return 0;

        int clicks = ((last - first) / 100) + 1;

        // if we start from exact boundary we don't count click like eg. 100->102
        if (prevPos % 100 == 0) {
            clicks--;
        }

        return Math.max(clicks, 0);
    }

    public boolean checkDirection (char dir) {
        return dir == 'R'; // return true when R
    }
}
