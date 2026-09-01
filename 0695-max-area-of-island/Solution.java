class Solution {

    static int bfs(int row, int col, int[][] vis, int[][] grid) {

        vis[row][col] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});

        int count = 1;

        while (!q.isEmpty()) {

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];

            // top
            if (r - 1 >= 0 &&
                grid[r - 1][c] == 1 &&
                vis[r - 1][c] == 0) {

                vis[r - 1][c] = 1;
                q.add(new int[]{r - 1, c});
                count++;
            }

            // left
            if (c - 1 >= 0 &&
                grid[r][c - 1] == 1 &&
                vis[r][c - 1] == 0) {

                vis[r][c - 1] = 1;
                q.add(new int[]{r, c - 1});
                count++;
            }

            // right
            if (c + 1 < grid[0].length &&
                grid[r][c + 1] == 1 &&
                vis[r][c + 1] == 0) {

                vis[r][c + 1] = 1;
                q.add(new int[]{r, c + 1});
                count++;
            }

            // bottom
            if (r + 1 < grid.length &&
                grid[r + 1][c] == 1 &&
                vis[r + 1][c] == 0) {

                vis[r + 1][c] = 1;
                q.add(new int[]{r + 1, c});
                count++;
            }
        }

        return count;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        int max = 0;

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (grid[row][col] == 1 &&
                    vis[row][col] == 0) {

                    int area = bfs(row, col, vis, grid);

                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }
}