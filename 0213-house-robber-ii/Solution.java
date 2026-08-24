class Solution {
    public int rob(int[] nums) {
        //first house is the neighbour of last house
        //01 ks?
        //basecase
        if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 0){
            return 0;
        }
       int n = nums.length;
       int[] dp = new int[n+1];
       int[] dp2 = new int[n+1];
       //two cases ->
       //1 first element is included
       dp[0] = nums[0];
       dp[1] = Math.max(nums[0],nums[1]);
       for(int i=2;i<n-1;i++){
            dp[i]= Math.max(dp[i-1],dp[i-2] + nums[i]);
       }
       dp2[1] = nums[1];
       dp2[2] = Math.max(nums[1],nums[2]);
       for(int i=3;i<n;i++){
        dp2[i] = Math.max(dp2[i-1],dp2[i-2] + nums[i]);
       }
       //last element is included
       return Math.max(dp[n-2],dp2[n-1]);
    }   
    
}