class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int sum = 0;
        int max = 1;
        int n = arr.length;
        String sign = "";
        String oldsign = "";
        for (int i = 0; i < n - 1; i++) {
            oldsign = sign;
            if (arr[i] > arr[i + 1]) {
                sign = "greater";
            } else if (arr[i] < arr[i + 1]) {
                sign = "smaller";
            } else {
                sign = "equal";
            }
            if (sign.equals("equal")) {
                sum = 0;
            } else if (!oldsign.isEmpty() && !oldsign.equals(sign)) {
                sum++;
            } else {
                sum = 1;
            }
            max = Math.max(max, sum + 1);
        }
        return max;
    }
}