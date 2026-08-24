class Solution {

    public boolean isHappy(int n) {
        return recursiveFunction(n, new HashSet<>());
    }
    public boolean recursiveFunction(int n, HashSet<Integer> set) {
        if (n == 1) {
            return true;
        }
        if (set.contains(n)) {
            return false;
        }
        set.add(n);
        int sum = 0;
        while (n > 0) {
            int last = n % 10;
            sum += last * last;
            n = n / 10;
        }
        return recursiveFunction(sum, set);
    }
}