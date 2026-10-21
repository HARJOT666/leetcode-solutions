class Solution {
    public int subsetXORSum(int[] nums) {
        //we just need to form a list containing all the subsets of nums and perform xor operation
        int ans = formSUbsets(nums);
        return ans;
    }
    public int formSUbsets(int[] nums){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num : nums) {
            int n = ans.size();
            for(int i = 0; i < n; i++) {
                List<Integer> temp = new ArrayList<>(ans.get(i));
                temp.add(num);
                ans.add(temp);
            }
        }
        //now just xor the subsets\
        int sum = 0;
        for(int i=0;i<ans.size();i++){
            sum+= xor(ans.get(i));
        }
        return sum;
    }
        public int xor(List<Integer> list) {
            int ans = 0;
            for(int i = 0; i < list.size(); i++) {
                ans = ans ^ list.get(i);
            }
            return ans;
        }
}