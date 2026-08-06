class Solution {
        public long spaceOptimization(int[] prices, int k) {

        long[][] prev = new long[k + 1][3];
        long[][] curr = new long[k + 1][3];

        // Day 0 initialization
        for (int t = 1; t <= k; t++) {
            prev[t][1] = -prices[0];
            prev[t][2] = prices[0];
        }

        for (int i = 1; i < prices.length; i++) {

            for (int t = 1; t <= k; t++) {

                // Neutral State
                curr[t][0] = Math.max(
                        prev[t][0],
                        Math.max(
                                prev[t][1] + prices[i],
                                prev[t][2] - prices[i]
                        )
                );

                // Buy State
                curr[t][1] = Math.max(
                        prev[t][1],
                        prev[t - 1][0] - prices[i]
                );

                // Short State
                curr[t][2] = Math.max(
                        prev[t][2],
                        prev[t - 1][0] + prices[i]
                );
            }

            long[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        long ans = 0;

        for (int t = 0; t <= k; t++)
            ans = Math.max(ans, prev[t][0]);

        return ans;
    }
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        return spaceOptimization(prices, k);
    }
}