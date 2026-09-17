class Solution {
    public int hammingWeight(int n) {
        String binary = Integer.toBinaryString(n);
        int k = binary.length();
        int count = 0;
        for(int i=0;i<k;i++){
            if(binary.charAt(i) == '1'){
                count++;
            }
        }
        return count;
    }
}