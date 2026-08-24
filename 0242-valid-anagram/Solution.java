class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n != m){
            return false;
        }
        char[] dp = new char[n];
         char[] dp2 = new char[n];
        for(int i = 0;i<n;i++){
            dp[i] = s.charAt(i);
        }
        for(int i=0;i<n;i++){
            dp2[i] = t.charAt(i);
        }
        Arrays.sort(dp);
        Arrays.sort(dp2);
        for(int i= 0;i<n;i++){
            if(dp[i] != dp2[i]){
                return false;
            }
        }
        return true;
    }
}