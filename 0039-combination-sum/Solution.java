class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
       
            backTrack(candidates,target,ans,list,0);
        
        return list;
    }
    public void backTrack(int[] arr,int target,List<Integer> ans,List<List<Integer>> list,int index){
        //base condition
        if(sum(ans) > target){
            return;
        }
        if(sum(ans) == target){
            list.add(new ArrayList<>(ans));
            return;
        }

        for(int i=index;i<arr.length;i++){
            //choose
            ans.add(arr[i]);
            backTrack(arr,target,ans,list,i);
            ans.remove(ans.size() - 1);
        }
    }
    public int sum(List<Integer> list){
        int sum = 0;
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
        }
        return sum;
    }
}