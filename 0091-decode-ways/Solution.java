class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        for(int i=0;i<s.length();i++){
            dp[i] = -1;
        }
        return solve(s, 0,dp);
    }
    public int solve(String s,int index,int[] dp){
        //base condition
         // Reached the end = one valid decoding
            if (index == s.length()) {
                return 1;
            }
            if (s.charAt(index) == '0') {
                return 0;
        }
            if(dp[index] != -1){
                return dp[index];
            }
        //i have 2 choices
        //1 take only one digit
        int count = solve(s,index+1,dp);
        // take 2 digits
        if(index + 1 < s.length()){
            int num = Integer.parseInt(s.substring(index,index+2));
            if(num >=10 && num<=26){
                count += solve(s,index+2,dp);
            }
        }
        dp[index] = count;
        return count;
    }
}