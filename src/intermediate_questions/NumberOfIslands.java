package intermediate_questions;

import java.util.Arrays;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }

                numIslands++;
                visit(i, j, grid);
            }
        }
        return numIslands;
    }

    private void visit(int i, int j, char[][] grid) {
        if (i < 0 || i > grid.length - 1) {
            return;
        }
        if (j < 0 || j > grid[0].length - 1) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        visit(i - 1, j, grid);
        visit(i + 1, j, grid);
        visit(i, j + 1, grid);
        visit(i, j - 1, grid);
    }
}
