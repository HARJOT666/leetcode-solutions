class Solution {
    public void moveZeroes(int[] nums) {
        //count the number of zeros
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                count++;
            }
            else{
                list.add(nums[i]);
            }
        }
        for(int i=0;i<count;i++){
            list.add(0);
        }
        int m = list.size();
        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i] = list.get(i);
        }
        for(int i=0;i<n;i++){
            nums[i] = arr[i];
        }
    }
}