class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return recurse(m, n, 0, 0, dp);
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