class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int bp = prices[0];

        int profit = 0;
        
        for(int i=1; i<n; i++){
            if(prices[i] > bp){
                profit = Math.max(profit, prices[i] - bp);
            }else bp = prices[i];
        }
        return profit;
    }
}