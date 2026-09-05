class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int i = 0;
        int j = 0;
        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        TreeMap<Integer, Integer> q = new TreeMap<>();

        while(j < n) {

            // add entering element
            q.put(nums[j], q.getOrDefault(nums[j], 0) + 1);

            if(j - i + 1 == k) {

                // maximum
                list.add(q.lastKey());

                // remove leaving element
                q.put(nums[i], q.get(nums[i]) - 1);

                if(q.get(nums[i]) == 0) {
                    q.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        int[] arr = new int[list.size()];

        for(int k1 = 0; k1 < list.size(); k1++) {
            arr[k1] = list.get(k1);
        }

        return arr;
    }
}