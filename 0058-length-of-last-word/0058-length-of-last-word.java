class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;

        // Remove trailing spaces
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        // Count the length of the last word
        while (end >= 0 && s.charAt(end) != ' ') {
            ans++;
            end--;
        }

        return ans;
    }
}