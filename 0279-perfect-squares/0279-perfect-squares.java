class Solution {
    static final int INF = (int) 1e9;

    // Generate all perfect squares <= n
    public static int[] getSquares(int n) {
        int size = (int) Math.sqrt(n);
        int[] sq = new int[size];

        for (int i = 1; i <= size; i++) {
            sq[i - 1] = i * i;
        }

        return sq;
    }
    public int numSquares(int n) {
        int[] sq = getSquares(n);

        int[] dp = new int[n + 1];

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int square : sq) {

            // Left to Right because square can be reused
            for (int target = square; target <= n; target++) {

                dp[target] = Math.min(dp[target],
                        1 + dp[target - square]);
            }
        }

        return dp[n] >= INF ? -1 : dp[n];
    }
}