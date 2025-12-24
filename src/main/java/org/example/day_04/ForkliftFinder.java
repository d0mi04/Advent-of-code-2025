package org.example.day_04;

import org.example.shared.DataSet;

import java.util.ArrayList;

public class ForkliftFinder {

    private static final int[] DIR_ROWS = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DIR_COLS = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int countAccessible(DataSet file) {
        ArrayList<String> grid = file.getLines();
        int accessible = 0;

        int rows = grid.size();
        int cols = grid.getFirst().length();

        // 1. visit every field on grid
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // 2. check if you have @. if not -> continue
                if(grid.get(row).charAt(col) != '@') continue;

                // 3. count @ in neighbourhood
                if(hasLessThanFourNeighbors(grid, row, col, rows, cols)) {
                    accessible++;
                }
            }
        }
        return accessible;
    }

    private static boolean hasLessThanFourNeighbors(
            ArrayList<String> grid, int r, int c, int rows, int cols) {

        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nr = r + DIR_ROWS[i];
            int nc = c + DIR_COLS[i];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                if (grid.get(nr).charAt(nc) == '@') {
                    count++;
                    if (count == 4) return false; // early exit
                }
            }
        }
        return true;
    }
}
