class Solution {

    // Function to build LPS (Longest Prefix Suffix) array
    public void lpsFind(int[] lps, String s) {
        int prefix = 0;
        int suffix = 1;

        while (suffix < s.length()) {

            // Match
            if (s.charAt(prefix) == s.charAt(suffix)) {
                lps[suffix] = prefix + 1;
                prefix++;
                suffix++;
            }
            // Not matched
            else {
                if (prefix == 0) {
                    lps[suffix] = 0;
                    suffix++;
                } else {
                    prefix = lps[prefix - 1];
                }
            }
        }
    }

    public int strStr(String haystack, String needle) {

        if (needle.length() == 0) return 0;

        int[] lps = new int[needle.length()];
        lpsFind(lps, needle);

        int first = 0, second = 0;

        while (first < haystack.length() && second < needle.length()) {

            // Match
            if (haystack.charAt(first) == needle.charAt(second)) {
                first++;
                second++;
            }
            // Not match
            else {
                if (second == 0) {
                    first++;
                } else {
                    second = lps[second - 1];
                }
            }
        }

        // If full match found
        if (second == needle.length()) {
            return first - second;
        }

        return -1;
    }
}