class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return recurse(grid, m, n, 0, 0, dp);
    }
    
    public int recurse(int[][] grid, int m, int n, int i, int j, int[][] dp) {
        if(i == m - 1 && j == n - 1)
            return grid[i][j];
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        
        if(j + 1 < n)
            right = grid[i][j] + recurse(grid, m, n, i , j + 1, dp);
        
        if(i + 1 < m)
            down = grid[i][j] + recurse(grid, m, n, i + 1, j, dp);
        
        return dp[i][j] = Math.min(down, right);
    }
}