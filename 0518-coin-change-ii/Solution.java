class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(coins,0,amount,dp);
        return ans;
    }
        public int solve(int[] coins, int i, int j, int[][] dp) {
        if (j == 0) {
            return 1;
        }
        if (i >= coins.length || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take = solve(coins, i, j - coins[i], dp);
        int skip = solve(coins, i + 1, j, dp);
        dp[i][j] = take + skip;
        return dp[i][j];
    }
}