class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        int right = 0;
        int down = 0;
        
        for(int i = m - 1;i>=0;i--) {
            for(int j = n - 1;j>=0;j--) {
                if(i == m - 1 && j == n - 1)
                    dp[i][j] = 1;
                else {
                    right = 0;
                    down = 0;
                    if(j + 1 < n)
                        right = dp[i][j+1];
                    if(i + 1 < m)
                        down = dp[i + 1][j];
                    dp[i][j] = down + right;
                }       
            }
        }
        
        return dp[0][0];
    }
    
    public int recurse(int m, int n, int i, int j, int[][] dp) {
        if(i == m - 1 && j == n - 1)
            return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int right = 0;
        int down = 0;
        
        if(j + 1 < n)
            right = recurse(m, n, i, j + 1, dp);
        
        if(i + 1 < m)
            down = recurse(m, n, i + 1, j, dp);
        
        
        return dp[i][j] = down + right;
    }
}