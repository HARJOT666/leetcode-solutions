class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(intervals[i][0]);
            temp.add(intervals[i][1]);
            list.add(temp);
        }

        // sort only ONCE
        list.sort((a, b) -> a.get(0) - b.get(0));

        // your recursive merging
        list = overLapping(list, 0);

        int k = list.size();
        int[][] arr = new int[k][2];

        for(int i = 0; i < k; i++){
            for(int j = 0; j < 2; j++){
                arr[i][j] = list.get(i).get(j);
            }
        }

        return arr;
    }

    public List<List<Integer>> overLapping(List<List<Integer>> list, int i){

        if(i >= list.size() - 1){
            return list;
        }

        if(list.get(i).get(1) >= list.get(i+1).get(0)){

            List<Integer> merged = new ArrayList<>();

            merged.add(list.get(i).get(0));

            int end = Math.max(
                list.get(i).get(1),
                list.get(i+1).get(1)
            );

            merged.add(end);

            list.set(i, merged);
            list.remove(i+1);

            return overLapping(list, i);
        }

        return overLapping(list, i+1);
    }
}