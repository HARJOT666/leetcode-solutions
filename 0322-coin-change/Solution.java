class Solution {

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[amount + 1][coins.length];

        for(int i = 0; i <= amount; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = dpHi(coins, amount, 0, dp);

        if(ans == Integer.MAX_VALUE){
            return -1;
        }

        return ans;
    }

    public int dpHi(int[] coins, int amount, int index, int[][] dp){

        if(index >= coins.length || amount < 0){
            return Integer.MAX_VALUE;
        }

        if(amount == 0){
            return 0;
        }

        if(dp[amount][index] != -1){
            return dp[amount][index];
        }

        // option 1 -> choose the coin
        int choose = dpHi(coins, amount - coins[index], index, dp);

        // option 2 -> skip the coin
        int skip = dpHi(coins, amount, index + 1, dp);

        if(choose != Integer.MAX_VALUE){
            choose++;
        }

        dp[amount][index] = Math.min(choose, skip);

        return dp[amount][index];
    }
}