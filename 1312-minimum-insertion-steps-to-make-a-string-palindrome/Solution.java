class Solution {
    public int minInsertions(String s) {
        String b = new StringBuilder(s).reverse().toString();
        int lengt = lcs(s,b);
        return s.length() - lengt;
    }
    public int lcs(String s,String b){
        int n = s.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];
        //initialization
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if (s.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}