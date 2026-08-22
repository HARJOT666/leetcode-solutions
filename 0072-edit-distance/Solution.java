class Solution {

    public int minDistance(String word1, String word2) {

        return lcs(word1, word2);
    }

    public int lcs(String s, String b) {

        int n = s.length();
        int m = b.length();

        int[][] dp = new int[n + 1][m + 1];

        // Empty string cases
        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i <= n; i++) {

            for(int j = 1; j <= m; j++) {

                if(s.charAt(i - 1) == b.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    dp[i][j] = 1 + Math.min(
                        dp[i - 1][j],                  // delete
                        Math.min(
                            dp[i][j - 1],              // insert
                            dp[i - 1][j - 1]           // replace
                        )
                    );
                }
            }
        }

        return dp[n][m];
    }
}