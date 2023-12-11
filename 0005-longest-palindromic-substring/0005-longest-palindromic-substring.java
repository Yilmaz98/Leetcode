class Solution {
    public String longestPalindrome(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        int count = 0;
        int len = 0;
        String result = new String();
        
        for(int g=0;g<m;g++) {
            for(int i=0,j=g;j<m;i++,j++) {
                if(g == 0) {
                    dp[i][j] = true;
                } else if(g == 1) {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j] == true) {
                    result = s.substring(i, j + 1);
                }
            }
        }
        
        return result;
    }
}