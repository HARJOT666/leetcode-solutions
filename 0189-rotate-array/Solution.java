class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> list= new ArrayList<>();

        k = k % nums.length;
        for(int i=nums.length -k;i<nums.length;i++){
            list.add(nums[i]);
        }    
        for(int i=0;i<nums.length - k;i++){
            list.add(nums[i]);
        }
        int n = list.size();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
           arr[i] = list.get(i);
        }
        for(int i=0;i<n;i++){
            nums[i] = arr[i];
        }
     }
}