class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n+1][2];
        
        for(int i=0;i<=n;i++){
            dp[i][0] = -1;
            dp[i][1] = -1;
        }
        int answer = bsdks(0,dp,n,0,prices);
        return Math.max(0,answer);
    }
    public int bsdks(int days,int[][] dp,int n,int hold,int[] prices){
        if(days == n){
            return 0;
        }
        
        if(dp[days][hold] != -1){
            return dp[days][hold];
        }
        
        //i have two options either buy or sell
        //days cannot be same obviously
        
        if(hold == 0){
             int buy = -prices[days] + bsdks(days+1,dp,n,1,prices);
             int skip = bsdks(days+1,dp,n,0,prices);
             dp[days][hold] = Math.max(buy,skip);
        }
        else{
            int sell = prices[days] ;
            int skip = bsdks(days+1,dp,n,1,prices);
            dp[days][hold] = Math.max(sell,skip);
        }
        
       
        return dp[days][hold];
    }
}