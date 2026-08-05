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

    public static int bottomUp(int [] prices){
        int  n = prices.length, no_of_transaction = 2, buy = 1;

        int [] [] [] dp = new int[n+1][2][3];

        for(int td [][] : dp){
            for(int row[] : td){
                Arrays.fill(row, 0); // to handle base -> k =0 sab 0, i=n sab 0
            }
        }
        
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<=buy; j++){
                for(int k=1; k<= no_of_transaction; k++){  // k 1 se start hai karan no of transaction 0 is base case
                    if(j==1){
                        dp[i][j][k] = Math.max(
                            -prices[i] + dp[i+1][0][k],
                            dp[i+1][1][k]
                        );
                    }else{
                        dp[i][j][k] = Math.max(
                            prices[i] + dp[i+1][1][k-1],
                            dp[i+1][0][k]
                        );
                    }
                }
            }
        }
        return dp[0][1][2];
    }
    public int maxProfit(int[] prices) {
        int i = 0, n = prices.length, no_of_transaction = 2, buy = 1;
        //Recursive Solution
        // return maxProfit(i, n, buy, no_of_transaction, prices);

        // Top Down DP
        // int [] [] [] dp = new int[n+1][2][3];

        // for(int td [][] : dp){
        //     for(int row[] : td){
        //         Arrays.fill(row, -1);
        //     }
        // }
        // return maxProfit1(i,n,buy, no_of_transaction, prices, dp);

        // Bottom Up
        return bottomUp(prices);
    }
}