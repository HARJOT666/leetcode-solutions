class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        bfs(mat,distance);
        return distance;
    }
    public void bfs(int[][] mat,int[][] distance){
        //i can traverse in 4 directions
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
      // Put all 0s into the queue
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    distance[i][j] = 0;
                }
            }
        }
        while(!q.isEmpty()){
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            //top
            if(r-1 >=0 && visited[r-1][c] == false){
                    visited[r-1][c] = true;
                    distance[r-1][c] = distance[r][c] + 1;
                    q.add(new int[]{r-1,c});
            }
            //bottom
            if(r+1 < mat.length && visited[r+1][c] == false){
                    visited[r+1][c] = true;
                    distance[r+1][c] = distance[r][c] + 1;
                    q.add(new int[]{r+1,c});
            }
            //right
            if(c+1 < mat[0].length && visited[r][c+1] == false){
                    visited[r][c+1] = true;
                    distance[r][c+1] = distance[r][c] + 1;
                    q.add(new int[]{r,c+1});
            }
            //left
            if(c-1 >=0 && visited[r][c-1] ==false){
                visited[r][c-1] = true;
                distance[r][c-1] = distance[r][c] + 1;
                q.add(new int[]{r,c-1});
            }
        } 
    }
}
