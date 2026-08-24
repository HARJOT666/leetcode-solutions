class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        ArrayList<List<String>> listnew = new ArrayList<>();
        boolean[] isVisited = new boolean[n];
        for(int i = 0;i<n;i++){
            if (isVisited[i]) {
                continue;
            }
            ArrayList<String> list= new ArrayList<>();
            list.add(strs[i]);
            for(int j=i+1;j<n;j++){
                if(isAnagram(strs[i],strs[j]) && !isVisited[j]){
                    list.add(strs[j]);
                    isVisited[j] = true;
                }
            }
            listnew.add(list);
        }
        return listnew;
    }
    
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