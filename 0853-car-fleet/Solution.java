class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int fleets = 0;
        //bc
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = speed.length;
        for(int i = 0;i<n;i++){
            map.put(position[i],speed[i]);
        }

        //how about i store a list/array of path like if car 1 has speed 1 and it starts at 0 miles so it takes 12 hours to reach the target and if it encounters any other car in that interval then it gets added in the fleet otherwise it itself is a fleet and we like remove the added car from the fleet because obvisouly if it is in fleet with this car thrn it can be in fleet with other car only if that other car is in fleet with car 1

        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double)(target - position[i]) / speed[i];
        }
        //but by this logic i have to make like n arr of distance sort them and then compare
        //if there is a match means that forms a group and one of the car is then removed
        //would that like pass all the testcases ?
        // NOOOOOOOOOOOOO
        double previousTime = 0;
        for (Map.Entry<Integer, Integer> entry :
                map.descendingMap().entrySet()) {
                int pos = entry.getKey();
                int spe = entry.getValue();
                double currentTime = (double)(target - pos) / spe;
                if(currentTime <= previousTime){
                    //do not update the previous time and do not update fleet
                    continue;
                }       
                else{
                    fleets++;
                    previousTime = currentTime;
                }
            }

        return fleets;
    }
}