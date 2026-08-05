class Solution {
    // Recursive Solution
    public static int maxProfit(int i, int n, int buy, int not, int [] a){
        if(i == n || not == 0) return 0;

        if(buy == 1){
            return Math.max(
                // buy
                -a[i] + maxProfit(i+1, n, 0, not, a),
                // not buy
                maxProfit(i+1, n, 1, not, a)
            );
        }else{
            return Math.max(
                //sell
                a[i] + maxProfit(i+1, n, 1, not-1, a),
                // not sell
                maxProfit(i+1, n, 0, not, a)
            );
        }
    }

    // Top Down Dp
    public static int maxProfit1(int i, int n, int buy, int not, int [] a, int [][][] dp){
        if(i == n || not == 0) return 0;
        if(dp[i][buy][not] != -1) return dp[i][buy][not];
        if(buy == 1){
            return dp[i][buy][not] =  Math.max(
                // buy
                -a[i] + maxProfit1(i+1, n, 0, not, a,dp),
                // not buy
                maxProfit1(i+1, n, 1, not, a,dp)
            );
        }else{
            return dp[i][buy][not] =  Math.max(
                //sell
                a[i] + maxProfit1(i+1, n, 1, not-1, a,dp),
                // not sell
                maxProfit1(i+1, n, 0, not, a,dp)
            );
        }
    }
    public int maxProfit(int[] prices) {
        int i = 0, n = prices.length, no_of_transaction = 2, buy = 1;
        //Recursive Solution
        // return maxProfit(i, n, buy, no_of_transaction, prices);

        // Top Down DP
        int [] [] [] dp = new int[n+1][2][3];

        for(int td [][] : dp){
            for(int row[] : td){
                Arrays.fill(row, -1);
            }
        }
        return maxProfit1(i,n,buy, no_of_transaction, prices, dp);
    }
}