class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //k closesst integers to x
        int n  = arr.length;
        int[] distance = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            distance[i] = Math.abs(arr[i] - x);
        }
        List<Integer> list = new ArrayList<>();
        while (k > 0) {
        int min = Integer.MAX_VALUE;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (distance[i] == -1) {
                    continue;
                }
                if (distance[i] < min) {
                    min = distance[i];
                    index = i;
                }
                // tie → choose smaller element
                else if (distance[i] == min && arr[i] < arr[index]) {
                    index = i;
                }
            }
            list.add(arr[index]);
            // remove this element so we don't choose it again
            distance[index] = -1;
            k--;
        }
        Collections.sort(list);
        return list;
    }
}