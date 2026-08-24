class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            // Current interval is completely before newInterval
            if (intervals[i][1] < start) {
                list.add(intervals[i]);
            }
            // Current interval is completely after newInterval
            else if (intervals[i][0] > end) {
                if (!inserted) {
                    list.add(new int[]{start, end});
                    inserted = true;
                }
                list.add(intervals[i]);
            }
            // Current interval overlaps newInterval
            else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        // newInterval hasn't been inserted yet
        if (!inserted) {
            list.add(new int[]{start, end});
        }
        return list.toArray(new int[list.size()][]);
    }
}