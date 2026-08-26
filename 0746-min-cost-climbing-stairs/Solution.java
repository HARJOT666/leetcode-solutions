class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //after paying the cost either 1 step or 2 steps
        boolean paid = false;
        //min cost to reach the top
        //dp ka question
        int n = cost.length;
        int[] dp = new int[n+1];
        for(int i=2;i<=n;i++){
                dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2]+cost[i-2]) ;
            //count can be increased either by 1 or 2 depending on the next cost
        }
        return dp[n];
    }
}