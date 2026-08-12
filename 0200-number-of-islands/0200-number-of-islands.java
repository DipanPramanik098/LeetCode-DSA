import java.util.*;

class Solution {

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int count = 0;

        // Traverse the complete grid
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                // Found a new island
                if (grid[i][j] == '1' && !visited[i][j]) {

                    count++;

                    bfs(i, j, grid, visited);
                }
            }
        }

        return count;
    }

    public void bfs(
            int row,
            int col,
            char[][] grid,
            boolean[][] visited) {

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{row, col});

        visited[row][col] = true;

        // 4 directions: up, right, down, left
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int r = cell[0];
            int c = cell[1];

            // Check 4 neighbours
            for (int i = 0; i < 4; i++) {

                int newRow = r + dRow[i];
                int newCol = c + dCol[i];

                // Boundary + land + unvisited
                if (newRow >= 0 &&
                    newRow < grid.length &&
                    newCol >= 0 &&
                    newCol < grid[0].length &&
                    grid[newRow][newCol] == '1' &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;

                    queue.offer(new int[]{
                        newRow,
                        newCol
                    });
                }
            }
        }
    }
}