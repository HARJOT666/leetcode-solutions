class Solution {
    public int findKthLargest(int[] nums, int k) {
     int count = 1;
     PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
     for(int i=0;i<nums.length;i++){
        pq.add(nums[i]);
     }
     while(count < k ){
       pq.poll();
       count++;
     }
     return pq.poll();
    }
}