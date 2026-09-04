class Solution {
    public List<String> generateParenthesis(int n) {
        String s = "";
        List<String> list = new ArrayList<>();
        int open = 0;
        int close = 0;
        backTrack("",list,open,close,n);

        return list;
    }
    public void backTrack(String s,List<String> list,int open,int close,int n){
       if(s.length() == 2 * n){
            list.add(s);
            return;
       }
        if(open < n){
            backTrack(s + '(',list,open+1,close,n);
        }
        if(close < open){
            backTrack(s + ')',list,open,close+1,n);
        }
    }
}