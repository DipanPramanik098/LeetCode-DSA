class Solution {
    public int coinChange(int[] coins, int amount) {
        return TDP(coins, coins.length ,amount);
    }
        public static int TDP(int a[], int n, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for(int [] row : dp ){
            Arrays.fill(row, -1);
        }
        int ans = solveTD(a, n, target, dp);
        return ans >= 1e9 ? -1 : ans;
    }

    public static int solveTD(int[] a, int avaiCoin, int target, int[][] dp) {
        if (target == 0)
            return 0;
        if (avaiCoin == 0 || target < 0)
            return (int) 1e9; // ? 10 ^ 9
        if (dp[avaiCoin][target] != -1)
            return dp[avaiCoin][target];
        return dp[avaiCoin][target] = Math.min(
        1 + solveTD(a, avaiCoin, target - a[avaiCoin - 1], dp),
        solveTD(a, avaiCoin - 1, target, dp));
    }
}