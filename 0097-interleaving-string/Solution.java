class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            Arrays.fill(dp[i],-1);
        }
        if (n1 + n2 != s3.length()) {
            return false;
        }
        boolean answer = solve(s1,s2,s3,0,0,dp);
        return answer;
    }
    public boolean solve(String s1,String s2,String s3,int i,int j,int[][] dp){
        //base condition
        int count = i + j;
        if(count == s3.length()){
            return true;
        }
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }
        boolean selectS1 = false;
        boolean selectS2= false;
        // option 1: select from s1
        if(i < s1.length()){
            if (s1.charAt(i) == s3.charAt(i + j)) {
            selectS1 = solve(s1, s2, s3, i + 1, j, dp);
            }
        }
        // option 2: select from s2
        if(j < s2.length()){
            if (s2.charAt(j) == s3.charAt(i + j)) {
            selectS2 = solve(s1, s2, s3, i, j + 1, dp);
            }
        }
        boolean answer = selectS1 || selectS2;
        if (answer) {
            dp[i][j] = 1;
        } else {
            dp[i][j] = 0;
        }
        return answer;
    }
}