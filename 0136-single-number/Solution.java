class Solution {
    public int singleNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        List<Integer> distinct = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(!distinct.contains(nums[i])){
                distinct.add(nums[i]);
            }
         if((nums[i] ^ nums[i+1]) == 0 && !list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        if(!distinct.contains(nums[nums.length - 1])){
            distinct.add(nums[nums.length - 1]);
        }
        for(int x : distinct){
        if(!list.contains(x)){
            ans = x;
            break;
        }
        
}
    return ans;
    }
}