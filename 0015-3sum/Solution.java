class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 1; j++) {

                // Skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int index = findIndex(i, j, nums);

                if (index != -1) {

                    List<Integer> ans = new ArrayList<>();

                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(nums[index]);

                    list.add(ans);
                }
            }
        }

        return list;
    }

    public int findIndex(int i, int j, int[] nums) {

        int needed = -(nums[i] + nums[j]);

        int left = j + 1;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == needed) {
                return mid;
            }
            else if (nums[mid] < needed) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}