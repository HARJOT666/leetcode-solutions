class Solution {
    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<stones.length;i++){
            list.add(stones[i]);
        }
        //base condition
        if(stones.length == 0){
            return 0;
        }
        if(stones.length == 1){
            return stones[0];
        }
        while(list.size()  >1){
            Collections.sort(list);
            int diff = list.get(list.size() - 1) - (list.get(list.size() - 2));
            list.remove(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(diff);
        }
        if(list.size() == 0){
            return 0;
        }
        return list.get(0);
    }
}