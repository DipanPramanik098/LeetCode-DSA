class Solution {
        // Space Optimized
        public static int so(int [] prices, int no_of_transaction){
        int  n = prices.length, buy = 1;

        // int [] [] [] dp = new int[n+1][2][3];
        int [] [] prev = new int[2][no_of_transaction + 1];
        
        for(int i=n-1; i>=0; i--){
            // current row
            int [] [] curr = new int[2][no_of_transaction + 1];
            for(int row[] : curr){
                Arrays.fill(row, 0); // to handle base -> k =0 sab 0, i=n sab 0
            }
            for(int j=0; j<=buy; j++){
                for(int k=1; k<= no_of_transaction; k++){  // k 1 se start hai karan no of transaction 0 is base case
                    if(j==1){
                        curr[j][k] = Math.max(
                            -prices[i] + prev[0][k],
                            prev[1][k]
                        );
                    }else{
                        curr[j][k] = Math.max(
                            prices[i] + prev[1][k-1],
                            prev[0][k]
                        );
                    }
                }
            }
            prev = curr;
        }
        return prev[1][no_of_transaction];
    }
    public int maxProfit(int k, int[] prices) {
        return so(prices, k);
    }
}