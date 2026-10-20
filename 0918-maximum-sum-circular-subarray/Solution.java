class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int max = nums[0];
        int min = nums[0];
        int curMin = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
            curMin = Math.min(0, curMin) + nums[i];
            min = Math.min(min, curMin);
            total += nums[i];
        }
        if (max < 0) {
            return max;
        }
        return Math.max(max, total - min);
    }
}