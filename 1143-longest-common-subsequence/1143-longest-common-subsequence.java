class Solution {
    public int spaceOptimization(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        int[] next = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = m - 1; j >= 0; j--) {

                if (s1.charAt(i) == s2.charAt(j)) {

                    curr[j] = 1 + next[j + 1];

                } else {

                    curr[j] = Math.max(
                            next[j],
                            curr[j + 1]
                    );
                }
            }

            next = curr;
            curr = new int[m + 1];
        }

        return next[0];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        return spaceOptimization(text1, text2);
    }
}