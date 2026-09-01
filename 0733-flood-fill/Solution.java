class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int original = image[sr][sc];
        if(original == color){
            return image;
        }
        bfs(image,sr,sc,color,original);
        return image;
        
    }
    public void bfs(int[][] image,int sr,int sc,int color,int original){
        boolean[][] visited = new boolean[image.length][image[0].length];
        visited[sr][sc] = true;
        image[sr][sc] = color;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr,sc});
        while(!q.isEmpty()){
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
                       // top
            if (r - 1 >= 0 &&
                image[r - 1][c] == original && !visited[r-1][c]) {

                image[r - 1][c] = color;
                visited[r-1][c] = true;
                q.add(new int[]{r - 1, c});
            }
            // left
            if (c - 1 >= 0 &&
                image[r][c - 1] == original && !visited[r][c-1]) {

                image[r][c - 1] = color;
                visited[r][c-1] = true;
                q.add(new int[]{r, c - 1});
            }
            // right
            if (c + 1 < image[0].length &&
                image[r][c + 1] == original && !visited[r][c+1]) {
                image[r][c + 1] = color;
                visited[r][c+1] = true;
                q.add(new int[]{r, c + 1});
            }
            // bottom
            if (r + 1 < image.length &&
                image[r + 1][c] == original && !visited[r+1][c]) {
                image[r + 1][c] = color;
                visited[r+1][c] = true;
                q.add(new int[]{r + 1, c});
            }
        }

    }
}