class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length;
        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        int count = 0;
        int right = nums.length;

        for (int i = 0; i < right; i++) {
            sum += nums[i];
            count++;

            while (sum >= target) {
                ans = Math.min(ans, count);
                sum -= nums[left];
                left++;
                count--;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return 0;
        }

        return ans;
    }
}