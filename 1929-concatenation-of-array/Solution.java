class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int m = 2 * n;
        int[] newArr = new int[m];
        for(int i=0;i<n;i++){
            newArr[i] = nums[i];
        }
        for(int i=n;i<m;i++){
            newArr[i] = nums[i-n];
        }
        return newArr;
    }
}