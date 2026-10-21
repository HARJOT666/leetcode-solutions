class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {
            count += find(i, nums, k);
        }

        return count;
    }

    public int find(int startIndex, int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;

        for(int i = startIndex; i < n; i++) {
            sum += nums[i];

            if(sum == k) {
                count++;
            }
        }

        return count;
    }
}