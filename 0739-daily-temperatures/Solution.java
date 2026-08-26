class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            int currentTemp = temperatures[i];
            int j = i + 1;
            int newTemp = temperatures[j];
            while (j < n && newTemp <= currentTemp) {
                if (arr[j] == 0) {
                    j = n;
                    break;
                }
                j = j + arr[j];
                newTemp = temperatures[j];
            }
            if (j < n) {
                arr[i] = j - i;
            }
        }
        return arr;
    }
}