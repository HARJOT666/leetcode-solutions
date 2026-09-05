class Solution {
    public List<List<String>> partition(String s) {
        List<String> list = new ArrayList<>();
        List<List<String>> graph = new ArrayList<>();
        
        backTrack(s,list,graph,0);
        return graph;
    }

    //noraml backtrack question
    void backTrack(String s,List<String> list,List<List<String>> graph,int index){
        //base condition
        if(index == s.length()){
            if(checkForPalindrome(list)){
                graph.add(new ArrayList<>(list));
                return;
            }
        }
        for(int i=index;i<s.length();i++){
            //add the character
            String part = s.substring(index, i + 1);
            list.add(part);
            backTrack(s,list,graph,i+1);
            list.remove(list.size() - 1);
        }
    }
 boolean checkForPalindrome(List<String> list) {
    for (String str : list) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
    }
    return true;
}
}