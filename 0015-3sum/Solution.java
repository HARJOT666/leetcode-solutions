class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
for(int i = 0; i < n; i++){

    if(i > 0 && nums[i] == nums[i - 1]) continue;

    for(int j = i + 1; j < n; j++){

        if(j > i + 1 && nums[j] == nums[j - 1]) continue;

        int k = findIndex(i, j, nums);

        if(k != -1){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(nums[k]);
            ans.add(list);
        }
    }
}
        return ans;
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