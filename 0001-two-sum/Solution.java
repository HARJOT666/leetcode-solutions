class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int[] arr = new int[2];
        int index = -1;
      int n = nums.length;
      for(int i=0;i<n;i++){
        int j = target - nums[i];
        if(map.containsKey(j)){
            index = map.get(j);
        }
        
        if(index!=-1 && index!=i){
            arr[0] = i;
            arr[1] = index;
            return arr;
        }
      }
      return arr;
    }
   
}