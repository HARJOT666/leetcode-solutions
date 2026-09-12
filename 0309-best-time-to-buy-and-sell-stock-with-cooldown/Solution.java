class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int[][] dp = new int[days][2];

        for (int i = 0; i < days; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(dp,prices,0,days,false);

        return ans;
    }
    public int solve(int[][] dp, int[] prices, int count, int days, boolean holding) {

        int i = count;
        int j;

        if (holding) {
            j = 1;
        } else {
            j = 0;
        }

        if (count >= days) {
            return 0;
        }

        // memoization
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (holding) {

            // sell
            int sell = prices[count]
                    + solve(dp, prices, count + 2, days, false);

            // continue holding
            int hold =
                    solve(dp, prices, count + 1, days, true);

            dp[i][j] = Math.max(sell, hold);

        } else {

            // buy
            int buy = -prices[count]
                    + solve(dp, prices, count + 1, days, true);

            // skip
            int skip =
                    solve(dp, prices, count + 1, days, false);

            dp[i][j] = Math.max(buy, skip);
        }

        return dp[i][j];
    }
}