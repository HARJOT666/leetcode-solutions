class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int max = Math.max(n,m);
        String ans = "";
        int j = 0;
        for(int i=0;i<n;i++){
            ans+=word1.charAt(i);
            if(j < m){
                ans+=word2.charAt(j);
                 j++;
            }
        }
        if(n < m){
            for(int i=n;i<m;i++){
                ans+=word2.charAt(i);
            }
        }
        return ans;
    }
}