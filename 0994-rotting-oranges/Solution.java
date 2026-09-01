import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        return bfs(grid);
    }
    public int bfs(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        // Put ALL rotten oranges in queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int minutes = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int r = current[0];
                int c = current[1];
                // top
                if (r - 1 >= 0 &&
                    !visited[r - 1][c] &&
                    grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    visited[r - 1][c] = true;
                    q.add(new int[]{r - 1, c});
                }
                // left
                if (c - 1 >= 0 &&
                    !visited[r][c - 1] &&
                    grid[r][c - 1] == 1) {

                    grid[r][c - 1] = 2;
                    visited[r][c - 1] = true;

                    q.add(new int[]{r, c - 1});
                }

                // right
                if (c + 1 < grid[0].length &&
                    !visited[r][c + 1] &&
                    grid[r][c + 1] == 1) {

                    grid[r][c + 1] = 2;
                    visited[r][c + 1] = true;

                    q.add(new int[]{r, c + 1});
                }

                // bottom
                if (r + 1 < grid.length &&
                    !visited[r + 1][c] &&
                    grid[r + 1][c] == 1) {

                    grid[r + 1][c] = 2;
                    visited[r + 1][c] = true;

                    q.add(new int[]{r + 1, c});
                }
            }

            minutes++;
        }
        // Check if any fresh orange remains
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 )  {
                    return -1;
                }
            }
        }
        if(grid.length == 1 && grid[0].length == 1){
            return 0;
        }
       boolean allZero = true;

for (int i = 0; i < grid.length; i++) {

    for (int j = 0; j < grid[0].length; j++) {

        if (grid[i][j] != 0) {
            allZero = false;
            break;
        }
    }

    if (!allZero) {
        break;
    }
}

if (allZero) {
    return 0;
}
        return minutes - 1;
    }
}