class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        for (int mid = 0; mid < s.length(); mid++) {
            // Odd
            int left = mid;
            int right = mid;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > ans.length()) {
                    ans = s.substring(left, right + 1);
                }
                left--;
                right++;
            }
            // Even
            left = mid;
            right = mid + 1;
            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > ans.length()) {
                    ans = s.substring(left, right + 1);
                }

                left--;
                right++;
            }
        }
        return ans;
    }
}