class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();

  
        
            backTrack(nums,list,ans,0);
            
        
        return list;
    }
    public void backTrack(int[] nums,List<List<Integer>> list,List<Integer> ans,int index){
        //what is the base condition here?
            list.add(new ArrayList<>(ans));
        for(int i=index;i<nums.length;i++){
            ans.add(nums[i]);
            backTrack(nums,list,ans,i+1);
            ans.remove(ans.size() - 1);
           
        }
    }
}