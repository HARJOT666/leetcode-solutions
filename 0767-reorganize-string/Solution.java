
class Solution {
    public String reorganizeString(String s) {
        //return such that any two characters are not same
        //we can count the frequesny of a particular character

        int[] freq = new int[26];
        int[] copy = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            copy[s.charAt(i) - 'a']++;
        }

        Arrays.sort(copy);
        int max = copy[25];
        int sum = 0;

        for(int i=0;i<26;i++){
            sum+=freq[i];
        }

        sum = sum - max;

        if(max - sum >= 2){
            return "";
        }

        //else we form the cmbination string
        String ans = "";

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0;i<s.length();i++){

            char selected = ' ';
            int highest = 0;

            for(char ch : map.keySet()){

                if(map.get(ch) > highest &&
                   (ans.length() == 0 ||
                    ans.charAt(ans.length()-1) != ch)){

                    highest = map.get(ch);
                    selected = ch;
                }
            }

            if(highest == 0){
                return "";
            }

            ans += selected;

            //decrement its frequency
            map.put(selected, map.get(selected)-1);
        }

        return ans;
    }
}
