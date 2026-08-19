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
        return subsetSum(nums,target);
    }
    public boolean subsetSum(int[] nums,int target){
        //base condition
        if(target == 0 || nums.length == 0){
            return true;
        }
        int n = nums.length;
        boolean[][] dp = new boolean[nums.length+1][target + 1]; // matrix for storing result
        //INitialization
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        //recursion
        for(int i = 1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1] <=j){
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][target];
        
    }
}