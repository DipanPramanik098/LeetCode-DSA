class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return Min_CostBU(cost);
    }
    public static int Min_CostBU(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		dp[1] = arr[1];
		for (int i = 2; i < dp.length; i++) {
			int first = dp[i - 1];
			int sec = dp[i - 2];
			dp[i] = Math.min(first, sec) + arr[i];

		}
		return Math.min(dp[dp.length - 1], dp[dp.length - 2]);
    }
}