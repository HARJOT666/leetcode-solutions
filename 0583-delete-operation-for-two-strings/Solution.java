class Solution {
    public int minDistance(String word1, String word2) {
        //need to determint no of deletion + insertion
        //no of op = 2*len - lcs
        int lcsl = lcs(word1,word2);
        return (word1.length() + word2.length()) - 2*lcsl;
    }
    public int lcs(String s,String b){
        int n = s.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                if(i==j){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1 ) == b.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}