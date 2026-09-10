class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        // return an array of non-overlapping intervals
        // Assuming that the intervals array is given in sorted manner
        List<int[]> list = new ArrayList<>();
        int count = 0;
        for(int i=0;i<n;i++){
            list.add(intervals[i]);
        }
        merge(list);
        int[][] newArr = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 2; j++) {
                newArr[i][j] = list.get(i)[j];
            }
        }
        return newArr;
    }
   public void merge(List<int[]> list) {
    boolean merged = false;
    for (int i = 0; i < list.size() - 1; i++) {
        if (list.get(i)[1] >= list.get(i + 1)[0]) {
            int[] newInterval = {
                list.get(i)[0],
                Math.max(list.get(i)[1], list.get(i + 1)[1])
            };
            list.remove(i + 1);
            list.remove(i);
            list.add(i, newInterval);
            merged = true;
        }
    }
    if (merged) {
        merge(list);
    }
}
}