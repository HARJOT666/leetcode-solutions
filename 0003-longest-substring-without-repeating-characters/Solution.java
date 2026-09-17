class Solution {
    public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0){
            return 0;
        }

        List<Character> list = new ArrayList<>();

        int longest = 0;
        int max = 0;

        for(int i = 0; i < s.length(); i++){

            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
                longest++;
            }
            else{
                while(list.contains(s.charAt(i))){
                    list.remove(0);
                    longest--;
                }

                list.add(s.charAt(i));
                longest++;
            }

            max = Math.max(longest, max);
        }

        return max;
    }
}