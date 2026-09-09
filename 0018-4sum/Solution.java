class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // Store number -> index
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Use long to prevent overflow
                    long diff = (long) target
                              - nums[i]
                              - nums[j]
                              - nums[k];
                    // Only search the map if diff can fit in an int
                    if (diff >= Integer.MIN_VALUE &&
                        diff <= Integer.MAX_VALUE) {
                        int index =
                            map.getOrDefault((int) diff, -1);
                        // Make sure we don't reuse an element
                        if (index != -1 &&
                            index != i &&
                            index != j &&
                            index != k) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[index]);
                            Collections.sort(list);
                            // Avoid duplicate quadruplets
                            if (!ans.contains(list)) {
                                ans.add(list);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}