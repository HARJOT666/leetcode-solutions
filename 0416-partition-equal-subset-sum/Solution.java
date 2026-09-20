class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+= nums[i];
        }
        if(sum %2 != 0){
            return false;
        }
        int target = sum/2;
        Boolean[][] dp = new Boolean[n+1][target+1];
       
        return subsetSum(0,nums,target,dp);
    }
    public boolean subsetSum(int i,int[] nums,int target,Boolean[][] dp){
        //base condition
        if(target == 0 || nums.length == 0){
            return true;

        }
        if(i == nums.length || target < 0){
            return false;
        }
        if(dp[i][target] != null){
            return dp[i][target];
        }

        //2 choices
        //1 take=
        boolean take = subsetSum(i+1,nums,target - nums[i],dp);
        //2 not take
        boolean nottake = subsetSum(i+1,nums,target,dp);

        dp[i][target] = take || nottake;

        return dp[i][target];
    }
}