class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        return lcs(s1,s2);
    }
    public int lcs(String X, String Y) {

    int n = X.length();
    int m = Y.length();

    int[][] dp = new int[n + 1][m + 1];
        // Delete everything from X
        for(int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] + X.charAt(i - 1);
        }

        // Delete everything from Y
        for(int j = 1; j <= m; j++) {
            dp[0][j] = dp[0][j - 1] + Y.charAt(j - 1);
        }
    for(int i = 1; i <= n; i++) {

        for(int j = 1; j <= m; j++) {

            if(X.charAt(i - 1) == Y.charAt(j - 1)) {

                dp[i][j] =  dp[i - 1][j - 1];

            } else {

                dp[i][j] = Math.min(X.charAt(i-1) + dp[i - 1][j],Y.charAt(j-1)+ dp[i][j - 1]);
            }
        }
    }

    return dp[n][m];
    }
}