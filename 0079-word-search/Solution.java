class Solution {
    public boolean exist(char[][] board, String word) {
        List<String> list = new ArrayList<>();
        String op = "";
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                backTrack(i,j,board,op,word,visited,list);
            }
        }
        if(list.contains(word)){
            return true;
        }
        return false;
    }
    public void backTrack(int r,int c,char[][] board,String op,
                          String word,boolean[][] visited,List<String> list){
        // Out of bounds
        if(r < 0 || r >= board.length ||
           c < 0 || c >= board[0].length) {
            return;
        }
        if(word.length() == 1 && board[r][c] == word.charAt(0)){
            list.add(word);
            return;
        }
        // Already visited
        if(visited[r][c]) {
            return;
        }
        if(op.length() > word.length()){
            return;
        }

     
        // Character doesn't match
        if(board[r][c] != word.charAt(op.length())){
            return;
        }

           if( op.length() == word.length() - 1){
            list.add(word);
            return;
        }
        visited[r][c] = true;
        backTrack(r + 1, c, board, op + board[r][c], word, visited, list); // DOWN
        backTrack(r - 1, c, board, op + board[r][c], word, visited, list); // UP
        backTrack(r, c + 1, board, op + board[r][c], word, visited, list); // RIGHT
        backTrack(r, c - 1, board, op + board[r][c], word, visited, list); // LEFT
        visited[r][c] = false;
    }
}