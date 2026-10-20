class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        for(int i=0;i<=s2.length()-n;i++){
            String combo = s2.substring(i,i+n);
            char[] a = combo.toCharArray();
            char[] b = s1.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            if (Arrays.equals(a, b)) {
                return true;
            }
        }
        return false;
    }
}