class Solution {

    public int maxProfit(int[] prices) {

        int[][] dp = new int[prices.length][2];

        for (int i = 0; i < prices.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return bsdka(0, prices, true, dp);
    }

    public int bsdka(int days, int[] prices, boolean canBuy, int[][] dp) {

        if (days == prices.length) {
            return 0;
        }

        int state = canBuy ? 1 : 0;

        if (dp[days][state] != -1) {
            return dp[days][state];
        }

        if (canBuy) {

            int buy = -prices[days] +
                      bsdka(days + 1, prices, false, dp);

            int hold = bsdka(days + 1, prices, true, dp);

            dp[days][state] = Math.max(buy, hold);
        }

        else {

            int sell = prices[days];

            int hold = bsdka(days + 1, prices, false, dp);

            dp[days][state] = Math.max(sell, hold);
        }

        return dp[days][state];
    }
}