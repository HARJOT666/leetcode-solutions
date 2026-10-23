import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        ArrayList<Character> list = new ArrayList<>();

        for(int i=0;i<senate.length();i++){
            list.add(senate.charAt(i));
        }

        while(list.contains('R') && list.contains('D')){
            for(int i=0;i<list.size();i++){
                for(int j=1;j<list.size();j++){
                    int next = (i+j)%list.size();

                    if(list.get(i)!=list.get(next)){
                        list.remove(next);

                        if(next<i){
                            i--;
                        }
                        break;
                    }
                }
            }
        }

        if(list.get(0)=='R'){
            return "Radiant";
        }
        return "Dire";
    }
}