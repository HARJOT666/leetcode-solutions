class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        return bsdka(0,dp,n,nums);
    }
    public int bsdka(int days,int[] dp,int n,int[] nums){
        //base condition
        if(days >= n){
            return 0;
        }
        if(dp[days] !=-1){
            return dp[days];
        }
        //2 options
        //1.Rob the current
       
        int left = nums[days] + bsdka(days+2,dp,n,nums);
        //2.skip the current and move to next
        int right = bsdka(days + 1, dp, n, nums);

        dp[days] = Math.max(left,right);

        return dp[days];
    }
}