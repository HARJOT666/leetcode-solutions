class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        boolean found = false;
        while(left < right){
            if(target == nums[left]){
                found = true;
                return left;
            }
            else{
                if(target > nums[left]){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        int i = 0;
        if(!found){
            //return the missing index
            
            while(i<nums.length){
                if(target < nums[i]){
                    return i;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
}