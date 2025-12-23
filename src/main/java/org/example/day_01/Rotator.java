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

    public void rotate() {
        int password = 0;
        for(String rotation : rotations) {
            char dir = rotation.charAt(0); // direction is the first letter in line
            int value = Integer.parseInt(rotation.substring(1)); // the rest is value to rotate
            if(checkDirection(dir)) {
                // if dir = 'R'
                currentPos += value;
            } else {
                // if dir = 'L'
                currentPos -= value;
            }
            if((currentPos % 100) == 0) { // checking when current position is set to 0
                password ++;
            }
//            System.out.println("Rotated: " + rotation + " Current position: " + currentPos);
        }
        System.out.println("Password: " + password);
    }

    public boolean checkDirection (char dir) {
        return dir == 'R'; // return true when R
    }
}
