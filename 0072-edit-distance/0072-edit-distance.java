class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return Editdistance(word1, word2, 0, 0, dp);
    }
    public static int Editdistance(String s, String t, int i, int j, int[][] dp) {
		if (i == s.length()) {
			return t.length() - j;

		}
		if (j == t.length()) {
			return s.length() - i;

		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		int ans = 0;
		if (s.charAt(i) == t.charAt(j)) {
			ans = Editdistance(s, t, i + 1, j + 1, dp);// dp[i+1][j+1]
		} else {
			int D = Editdistance(s, t, i + 1, j, dp);// dp[i+1][j]
			int I = Editdistance(s, t, i, j + 1, dp);// dp[i][j+1]
			int R = Editdistance(s, t, i + 1, j + 1, dp);// dp[i+1][j+1]
			ans = Math.min(I, Math.min(D, R)) + 1;
		}
		return dp[i][j] = ans;

	}

}