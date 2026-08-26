class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int buyPrice = prices[0];
        for(int i = 1; i < n; i++){
            int sellPrice = prices[i];
            int profit = sellPrice - buyPrice;
            if(profit > max){
                max = profit;
            }
            if(prices[i] < buyPrice){
                buyPrice = prices[i];
            }
        }
        return max;
    }
}