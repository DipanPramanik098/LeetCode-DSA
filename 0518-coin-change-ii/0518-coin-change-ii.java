class Solution {
    public static int solve(int amount, int []c, int n, int [][] dp){
        if(amount==0) return 1;
        if(n==0 || amount<0) return 0;
        if(dp[n-1][amount] != -1) return dp[n-1][amount]; 
        return dp[n-1][amount] = solve(amount - c[n-1], c, n,dp) + solve(amount, c, n-1,dp);
    }
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int dp[][] = new int [n][amount + 1];
        for(int [] row : dp){
            Arrays.fill(row, -1);
        }
        return solve(amount, coins, n, dp);   
    }
}