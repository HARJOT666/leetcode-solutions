class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int sum = left;
        while(left<right){
            right = right & (right-1);
        }
        return sum&right;
    }
}