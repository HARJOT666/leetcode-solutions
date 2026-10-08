class Solution {
    public int islandPerimeter(int[][] grid) {
        //island only if it is horizontal or vertically connected
        int perimeter = 0;
        int neighbours = 0;
        //we should count non repeated neighbours and subtract the count of neighbours from the final answer
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    ans+=1;
                     if (i > 0 && grid[i-1][j] == 1) {
                        neighbours++;
                    }
                    if (i < grid.length-1 && grid[i+1][j] == 1) {
                        neighbours++;
                    }
                    if (j > 0 && grid[i][j-1] == 1) {
                        neighbours++;
                    }
                    if (j < grid[0].length-1 && grid[i][j+1] == 1) {
                        neighbours++;
                    }
                }
            }
        }
        return (ans *4) - neighbours;
    }
}