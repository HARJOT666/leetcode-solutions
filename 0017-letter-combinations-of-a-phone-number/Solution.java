class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, Character[]> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        map.put('2', new Character[]{'a', 'b', 'c'});
        map.put('3', new Character[]{'d', 'e', 'f'});
        map.put('4', new Character[]{'g', 'h', 'i'});
        map.put('5', new Character[]{'j', 'k', 'l'});
        map.put('6', new Character[]{'m', 'n', 'o'});
        map.put('7', new Character[]{'p', 'q', 'r','s'});
        map.put('8', new Character[]{ 't', 'u','v'});
        map.put('9', new Character[]{ 'w', 'x','y','z'});
        StringBuilder op = new StringBuilder();
        backTrack(map,op,list,digits,0);
        return list;
        //now we use normal backtrackto
    }
     
    public void backTrack(
        Map<Character, Character[]> map,
        StringBuilder op,
        List<String> list,
        String digits,
        int index) {
    if (index==digits.length()) {
        list.add(op.toString());
        return;
    }
    char digit = digits.charAt(index);

    Character[] letters = map.get(digit);

    for (int i = 0; i < letters.length; i++) {

        // choose
        op.append(letters[i]);

        // explore
        backTrack(map, op, list, digits, index+1);

        // undo
        op.deleteCharAt(op.length() - 1);
    }
}
}