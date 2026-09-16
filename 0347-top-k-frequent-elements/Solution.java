class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        List<Integer> list = new ArrayList<>();

        while(!pq.isEmpty()) {
            list.add(pq.poll());
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int count = 1;

        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).equals(list.get(i + 1))) {
                count++;
            }
            else {
                map.put(list.get(i), count);
                count = 1;
            }
        }

        map.put(list.get(list.size() - 1), count);

        int[][] arr = new int[map.size()][2];

        int index = 0;

        for(int x : map.keySet()) {
            arr[index][0] = map.get(x);
            arr[index][1] = x;
            index++;
        }

        Arrays.sort(arr, (a, b) -> b[0] - a[0]);

        int[] ans = new int[k];

        for(int i = 0; i < k; i++) {
            ans[i] = arr[i][1];
        }

        return ans;
    }
}