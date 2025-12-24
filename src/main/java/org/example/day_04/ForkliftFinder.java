package org.example.day_04;

import org.example.shared.DataSet;

public class ForkliftFinder {
    public static int countAccessible(DataSet file) {
        int accessible = 0;

        int rows = file.getLines().size();
        int cols = file.getLines().getFirst().length();

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        // 1. przejdź po wszystkich polach
        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                // 2. sprawdź czy to @. Jeżeli nie -> pomiń
                if(file.getLines().get(row).charAt(col) != '@') continue;

                // 3. policz @ w 8 sąsiadach
                int accessibleNeighbours = 0;
                for(int i = 0; i < 8; i++) {
                    int nr = row + dr[i];
                    int nc = col + dc[i];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                        if(file.getLines().get(nr).charAt(nc) == '@') {
                            // 4. jeżeli @ jest < 4 -> accessible++
                            accessibleNeighbours++;
                        }
                    }
                }
                if(accessibleNeighbours < 4) {
                    accessible++;
                }
            }
        }
        return accessible;
    }
}
