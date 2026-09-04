class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] visited = new boolean[candidates.length];
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        int index = 0;
        backTrack(index,candidates,target,list,ans,visited);
        return list;
    }
    public void backTrack(int index,int[] arr, int target,List<List<Integer>> list,List<Integer> ans,boolean[] visited){
        //base conditin
        if(sum(ans) > target){
            return;
        }
        if(sum(ans) == target){
            List<Integer> temp = new ArrayList<>(ans);
            Collections.sort(temp);
            if (!list.contains(temp)) {
                list.add(temp);
                return;
            }
            return;
        }
        HashSet<Integer> seen = new HashSet<>();
        for(int i = index;i<arr.length;i++){
            // Same value already tried at this level
            if (seen.contains(arr[i])) {
                continue;
            }
            seen.add(arr[i]);
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            ans.add(arr[i]);
            backTrack(i+1,arr,target,list,ans,visited);
            ans.remove(ans.size() - 1);
            visited[i] = false;
        }
    }
    public int sum(List<Integer> list){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum+= list.get(i);
        }
        return sum;
    } 
}