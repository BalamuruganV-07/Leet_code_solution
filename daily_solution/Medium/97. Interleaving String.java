class Solution {

    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {

        // Length must match
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s2.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s3.toCharArray()) {
            freq[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        dp = new Boolean[s1.length() + 1][s2.length() + 1];

        return check(s1, s2, s3, 0, 0);
    }

    boolean check(String s1, String s2, String s3, int i, int j) {

        // Both strings completely used
        if (i == s1.length() && j == s2.length()) {
            return true;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int k = i + j;

        boolean ans = false;

        // Try taking character from s1
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            ans = check(s1, s2, s3, i + 1, j);
        }

        // If needed, try taking character from s2
        if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            ans = check(s1, s2, s3, i, j + 1);
        }

        return dp[i][j] = ans;
    }
}
