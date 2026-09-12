class Solution {
    public int uniquePaths(int m, int n) {
        //either down or right -> move allowed
        
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans =  solve(0,0,m,n,dp);
        return ans;
    }
    public int solve(int i,int j,int m,int n,int[][] dp){
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        //moves allowed
        // lets say i is the rows and j is the columns
        // 1st move -> [i+1][j] condition i<n
        // 2nd move -> [i][j+1] condition j<m
        int left = solve(i+1,j,m,n,dp);
        int right = solve(i,j+1,m,n,dp);
        dp[i][j] =  left + right;

        return dp[i][j];
    }
}