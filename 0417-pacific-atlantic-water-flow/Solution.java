
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Mark ocean boundaries
        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            atlantic[m - 1][j] = true;
        }

        boolean changed = true;

        while (changed) {
            changed = false;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // Check all four neighbors
                    int[] r = {i - 1, i + 1, i, i};
                    int[] c = {j, j, j - 1, j + 1};

                    for (int k = 0; k < 4; k++) {
                        int x = r[k];
                        int y = c[k];

                        if (x < 0 || y < 0 || x >= m || y >= n)
                            continue;

                        // Pacific reachability
                        if (pacific[x][y] &&
                            heights[i][j] >= heights[x][y] &&
                            !pacific[i][j]) {
                            pacific[i][j] = true;
                            changed = true;
                        }

                        // Atlantic reachability
                        if (atlantic[x][y] &&
                            heights[i][j] >= heights[x][y] &&
                            !atlantic[i][j]) {
                            atlantic[i][j] = true;
                            changed = true;
                        }
                    }
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}
