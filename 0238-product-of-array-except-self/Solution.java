class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];

        int ans = 1;
        int kime = 0;
        int count = 0;
        int zero = 0;

        while (kime < n) {
            if (nums[kime] == 0) {
                zero++;
            } else {
                ans *= nums[kime];
            }
            kime++;
        }

        while (count < n) {
            if (zero > 1) {
                arr[count] = 0;
            }
            else if (zero == 1) {
                if (nums[count] == 0) {
                    arr[count] = ans;
                } else {
                    arr[count] = 0;
                }
            }
            else {
                arr[count] = ans / nums[count];
            }

            count++;
        }

        return arr;
    }
}