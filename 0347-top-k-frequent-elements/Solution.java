class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] count = new int[nums.length];
        Arrays.sort(nums);
        int n = nums.length;
        int freq = 1;
        for(int i=1;i<n;i++){
            if(nums[i] == nums[i-1]){
                freq++;
            }
            else{
                count[i-1] = freq;
                freq = 1;
            }
        }
        count[n - 1] = freq;
        //we need to return the kth most repated element
        int[] copy = count.clone();
            Arrays.sort(copy);
        int kthMax = copy[n - k];
        int[] ans = new int[k];
        int j = 0;
        for(int i=0;i<n;i++){
            if(count[i] >= kthMax){
                ans[j] = nums[i];
                j++;
            }
        }
      return ans;
    }
}