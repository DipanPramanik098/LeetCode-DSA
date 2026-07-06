class Solution {
    static int [] dp = new int [100];
    static int fibb(int n){
        if(n<=1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = fibb(n-1) + fibb(n-2);
        return dp[n];
    }
    public int fib(int n) {
        Arrays.fill(dp,-1);
        return fibb(n);
    }
}