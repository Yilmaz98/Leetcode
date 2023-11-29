class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i], - 1);
        }
        return recurse(text1, text2, 0, 0, m, n, dp);
    }
    
    public int recurse(String text1, String text2, int i, int j, int m, int n, int[][] dp) {
        if(i >= m || j >= n)
            return 0;
        
        int pick = 0;
        int notPick = 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(text1.charAt(i) == text2.charAt(j)) {
            pick = 1 + recurse(text1, text2, i + 1, j + 1, m, n, dp);
        }
        
        notPick = Math.max(recurse(text1, text2, i + 1, j, m, n, dp), recurse(text1, text2, i, j+1, m, n, dp));
        
        return dp[i][j] = Math.max(pick, notPick);
    }
}