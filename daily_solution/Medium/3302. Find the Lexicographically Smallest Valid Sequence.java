class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        char c[]=word1.toCharArray();
        char b[]=word2.toCharArray();
        int dp[]=new int[n+1];

        for (int i = n - 1; i >= 0; i--){
            if((dp[i+1]<m) && (c[i]==b[m-dp[i+1]-1])){
                dp[i]=dp[i+1]+1;
            }
            else{
                dp[i]=dp[i+1];
            }
        }
        int[] ans = new int[m]; 
        int j = 0; 
        boolean changed = false; 
        for (int i = 0; i < n && j < m; i++) { 
            if (c[i] == b[j]) { 
                ans[j] = i; 
                j++; 
            } 
            else if (!changed && dp[i + 1] >= m - j - 1) { 
                ans[j] = i; 
                changed = true; 
                j++; 
            } 
        } 
        if (j < m) { 
            return new int[0]; 
        } 
        return ans;
    }
}
