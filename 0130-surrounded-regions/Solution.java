class Solution {

    char[][] updated;

    public void solve(char[][] board) {

        updated = new char[board.length][board[0].length];

        // Copy board into updated
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                updated[i][j] = board[i][j];
            }
        }
        bfs(board);
        // Copy updated back into board
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = updated[i][j];
            }
        }
    }
    public void bfs(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];

        // Start from boundary O's
        for(int i = 0; i < board.length; i++){

            if(board[i][0] == 'O'){
                q.add(new int[]{i,0});
                visited[i][0] = true;
            }

            if(board[i][board[0].length - 1] == 'O'){
                q.add(new int[]{i,board[0].length - 1});
                visited[i][board[0].length - 1] = true;
            }
        }

        for(int j = 0; j < board[0].length; j++){

            if(board[0][j] == 'O'){
                q.add(new int[]{0,j});
                visited[0][j] = true;
            }

            if(board[board.length - 1][j] == 'O'){
                q.add(new int[]{board.length - 1,j});
                visited[board.length - 1][j] = true;
            }
        }

        while(!q.isEmpty()){

            int[] current = q.poll();

            int r = current[0];
            int c = current[1];

            // These O's are SAFE, so keep them O
            updated[r][c] = 'O';

            // top
            if(r - 1 >= 0 &&
               board[r - 1][c] == 'O' &&
               visited[r - 1][c] == false){

                visited[r - 1][c] = true;
                q.add(new int[]{r - 1,c});
            }

            // bottom
            if(r + 1 < board.length &&
               board[r + 1][c] == 'O' &&
               visited[r + 1][c] == false){

                visited[r + 1][c] = true;
                q.add(new int[]{r + 1,c});
            }

            // left
            if(c - 1 >= 0 &&
               board[r][c - 1] == 'O' &&
               visited[r][c - 1] == false){

                visited[r][c - 1] = true;
                q.add(new int[]{r,c - 1});
            }

            // right
            if(c + 1 < board[0].length &&
               board[r][c + 1] == 'O' &&
               visited[r][c + 1] == false){

                visited[r][c + 1] = true;
                q.add(new int[]{r,c + 1});
            }
        }

        // Any O not visited is surrounded
        for(int i = 0; i < board.length; i++){

            for(int j = 0; j < board[0].length; j++){

                if(board[i][j] == 'O' && visited[i][j] == false){

                    updated[i][j] = 'X';
                }
            }
        }
    }
}