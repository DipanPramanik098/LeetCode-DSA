class Solution {
    // public int mp(int i, int buy, int n, int fee, int [] a){
    //     if(i == n) return 0;
    //     if(buy == 1){
    //         return Math.max(
    //             -a[i] + mp(i+1, 0, n, fee, a),
    //             mp(i+1, 1, n, fee, a)
    //         );
    //     }else{
    //         return Math.max(
    //             a[i] + mp(i+1, 1, n, fee, a) - fee,
    //             mp(i+1, 0, n, fee, a)
    //         );
    //     }
    // }

    public int mp(int i, int buy, int n, int fee, int [] a, int[][] dp){
        if(i == n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            return dp[i][buy] =  Math.max(
                -a[i] + mp(i+1, 0, n, fee, a, dp),
                mp(i+1, 1, n, fee, a, dp)
            );
        }else{
            return dp[i][buy] =  Math.max(
                a[i] + mp(i+1, 1, n, fee, a, dp) - fee,
                mp(i+1, 0, n, fee, a, dp)
            );
        }
    }

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int [][] dp = new int[n+1][2]; //2 - buy 0/1
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return mp(0,1,n,fee,prices,dp);
    }
}