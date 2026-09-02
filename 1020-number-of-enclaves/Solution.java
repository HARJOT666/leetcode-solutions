class Solution {

    public int numEnclaves(int[][] grid) {

        int count1 = 0;

        // Count original 0s
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 0){
                    count1++;
                }
            }
        }

        int[][] updated = new int[grid.length][grid[0].length];

        // Copy grid into updated
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){

                updated[i][j] = grid[i][j];
            }
        }

        bfs(grid, updated);

        int count2 = 0;

        // Count updated 0s
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){

                if(updated[i][j] == 0){
                    count2++;
                }
            }
        }

        // Number of surrounded 1s
        return count2 - count1;
    }


    public void bfs(int[][] grid, int[][] updated) {

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        // Add all boundary 1s
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 1 &&
                   (i == 0 ||
                    i == grid.length - 1 ||
                    j == 0 ||
                    j == grid[0].length - 1)){

                    q.add(new int[]{i,j});

                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){

            int[] node = q.poll();

            int r = node[0];
            int c = node[1];

            // top
            if(r - 1 >= 0 &&
               grid[r - 1][c] == 1 &&
               visited[r - 1][c] == false){

                visited[r - 1][c] = true;

                q.add(new int[]{r - 1,c});
            }

            // bottom
            if(r + 1 < grid.length &&
               grid[r + 1][c] == 1 &&
               visited[r + 1][c] == false){

                visited[r + 1][c] = true;

                q.add(new int[]{r + 1,c});
            }

            // left
            if(c - 1 >= 0 &&
               grid[r][c - 1] == 1 &&
               visited[r][c - 1] == false){

                visited[r][c - 1] = true;

                q.add(new int[]{r,c - 1});
            }

            // right
            if(c + 1 < grid[0].length &&
               grid[r][c + 1] == 1 &&
               visited[r][c + 1] == false){

                visited[r][c + 1] = true;

                q.add(new int[]{r,c + 1});
            }
        }

        // UPDATED: Change all unvisited 1s (enclaves) to 0
        for(int i = 0; i < grid.length; i++){

            for(int j = 0; j < grid[0].length; j++){

                if(grid[i][j] == 1 && visited[i][j] == false){

                    updated[i][j] = 0;
                }
            }
        }
    }
}