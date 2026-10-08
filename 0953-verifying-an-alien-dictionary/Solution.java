class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        //we compare character to character and verify the order 
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<order.length();i++){
            map.put(order.charAt(i),i);
        }
        if(words.length == 1){
            return true;
        }
        //there can be n words inside the words arrray
        for(int i = 0;i<words.length - 1;i++){
            String first = words[i];
            String second = words[i+1];
            boolean comp = compare(first,second,map);
            if(!comp){
                return false;
            }
        }
        return true;
    }
    public boolean compare(String first,String second,HashMap<Character,Integer> map){
        int n = first.length();
        int m = second.length();
        int k = Math.min(n,m);
        for(int i=0;i<k;i++){
            int j = map.get(first.charAt(i));
            int p = map.get(second.charAt(i));
            if(j < p){
                return true;
            }
            if(j == p){
                continue;
            }
            if(j > p){
                return false;
            }
        }
        return n<=m;
    }
}