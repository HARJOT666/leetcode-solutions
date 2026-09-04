class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        int index = 0;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backTrack(list,ans,nums,index,visited);
        return list;
    }
    public void backTrack(List<List<Integer>> list,List<Integer> ans,int[] nums,int index,boolean[] visited){
        Collections.sort(ans);
        list.add(new ArrayList<>(ans));
        HashSet<Integer> seen = new HashSet<>();
        for(int i=index;i<nums.length;i++){
            // Same value already tried at this level
            if (seen.contains(nums[i])) {
                continue;
            }
                 seen.add(nums[i]);   
                if (visited[i]) {
                    continue;
                }
                 // Choose
                 visited[i] = true;

                 ans.add(nums[i]);
                 backTrack(list,ans,nums,i+1,visited);

                 visited[i] = false;
                 ans.remove(ans.size() - 1);
        }
    }
}