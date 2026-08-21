class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int count1 = 0; // unmatched '('
        int count2 = 0; // insertions needed
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                count1++;
            } 
            else {
                // We need two consecutive ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++;
                } 
                else {
                    // Insert the missing ')'
                    count2++;
                }
                // This pair of ')' needs one '('
                if (count1 > 0) {
                    count1--;
                } 
                else {
                    // Insert missing '('
                    count2++;
                }
            }
        }
        // Remaining '(' need two ')' each
        count2 += 2 * count1;
        return count2;
    }
}