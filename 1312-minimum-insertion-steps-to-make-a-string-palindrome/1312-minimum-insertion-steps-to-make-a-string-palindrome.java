class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int lps = longestPalindromicSubsequence(s);
        
        System.out.println(n + ":" + lps);
        
        return n - lps;
    }
    
    public int longestPalindromicSubsequence(String a) {
        StringBuilder sb = new StringBuilder(a);
        sb.reverse();
        
        return lcs(a,sb.toString());
    }
    
    public int lcs(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 1;i<=m;i++) {
            for(int j = 1;j<=n;j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[m][n];
    }
}