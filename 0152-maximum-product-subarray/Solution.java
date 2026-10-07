class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {

            int x = nums[i];

            int tempMax = Math.max(x, Math.max(x * max, x * min));
            int tempMin = Math.min(x, Math.min(x * max, x * min));

            max = tempMax;
            min = tempMin;

            ans = Math.max(ans, max);
        }

        return ans;
    }
}