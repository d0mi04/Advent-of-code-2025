package org.example.day_04;

import org.example.shared.DataSet;

import java.util.ArrayList;
import java.util.List;

public class ForkliftFinder {

    private static final int[] DIR_ROWS = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DIR_COLS = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static int countTotalRemoveable(DataSet file) {
        char[][] grid = toGrid(file);
        int rows = grid.length;
        int cols = grid[0].length;

        int totalRemoveable = 0;

        while (true) {
            List<int[]> toRemove = new ArrayList<>();

            for(int row = 0; row < rows; row++) {
                for(int col = 0; col < cols; col++) {
                    if(grid[row][col] == '@' && hasLessThanFourNeighbors(grid, row, col, rows, cols)) {
                        toRemove.add(new int[]{row, col});
                    }
                }
            }

            if(toRemove.isEmpty()) break;

            for(int[] pos : toRemove) {
                grid[pos[0]][pos[1]] = '.';
            }

            totalRemoveable += toRemove.size();
        }
        return totalRemoveable;
    }

    public static int countAccessible(DataSet file) {
        char[][] grid = toGrid(file);
        int accessible = 0;

        int rows = grid.length;
        int cols = grid[0].length;

        // 1. visit every field on grid
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // 2. check if you have @. if not -> continue
                if(grid[row][col] != '@') continue;

                // 3. count @ in neighbourhood
                if(hasLessThanFourNeighbors(grid, row, col, rows, cols)) {
                    accessible++;
                }
            }
        }
        return accessible;
    }

    private static boolean hasLessThanFourNeighbors(
            char[][] grid, int r, int c, int rows, int cols) {

        int count = 0;

        for (int i = 0; i < 8; i++) {
            int nr = r + DIR_ROWS[i];
            int nc = c + DIR_COLS[i];

            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                if (grid[nr][nc] == '@') {
                    count++;
                    if (count == 4) return false; // early exit
                }
            }
        }
        return true;
    }

    private static char[][] toGrid(DataSet file) {
        ArrayList<String> lines = new ArrayList<>(file.getLines());
        int rows = lines.size();
        int cols = lines.getFirst().length();
        char[][] grid = new char[rows][cols];

        for(int i = 0; i < rows; i++) {
            grid[i] = lines.get(i).toCharArray();
        }

        return grid;
    }
}
