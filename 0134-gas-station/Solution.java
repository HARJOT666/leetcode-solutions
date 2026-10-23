class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currentIndex = 0;
        int currentGas = 0;
        int totalGas = 0; // NEW

        for(int i=0;i<gas.length;i++){
            int costTo = cost[i];

            currentGas = currentGas + gas[i] - costTo;
            totalGas = totalGas + gas[i] - costTo; // NEW

            if(currentGas < 0){
                currentIndex = i + 1;
                currentGas = 0;
            }
        }

        if(totalGas < 0){
            return -1;
        }

        return currentIndex;
    }
}