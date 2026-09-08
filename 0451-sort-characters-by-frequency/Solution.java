class Solution {
    public String frequencySort(String s) {
        int[] count = new int[s.length()];
       
        char[] arr = new char[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i] = s.charAt(i);
        }
        Arrays.sort(arr);
        String ans = "";
        int freq = 1;
        for(int i=1;i<s.length();i++){
            if(arr[i-1] == arr[i]){
                freq++;
            }
            else{
                count[i-1] = freq;
                freq = 1;
            }
        }
        int n = s.length();
        count[n-1] = freq;
        int[] copy = count.clone();
        Arrays.sort(copy);

        for (int j = n - 1; j >= 0; j--) {

    if (copy[j] == 0) {
        continue;
    }

    for (int i = 0; i < n; i++) {

        if (count[i] == copy[j]) {

            for (int x = 0; x < count[i]; x++) {
                ans += arr[i];
            }

            count[i] = 0;
            break;
        }
    }
}
        return ans;
    }
}