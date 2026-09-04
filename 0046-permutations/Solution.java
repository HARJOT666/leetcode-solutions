class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        List<Integer> ans = new ArrayList<>();
        backTrack(list, nums, visited, ans);

        return list;
    }
    public void backTrack(List<List<Integer>> list,int[] nums,boolean[] visited,List<Integer> ans){
        //base condition
        //if length of ans and other list inside list is same return
        if(ans.size() == nums.length){
            list.add(new ArrayList<>(ans));
            return;
        }
        //Try all choices
        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            ans.add(nums[i]);
            backTrack(list,nums,visited,ans);
            ans.remove(ans.size() - 1);
            visited[i] = false;
        }
    }
}