class Solution {
    int cherries;
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        return Math.max(0, backtrack(grid, 0, 0, 0, 0, new int[n][n][n][n], n));
    }
    
    public int backtrack(int[][] grid, int r1, int c1, int r2, int c2, int[][][][] dp, int n) {
        if(r1>=n || r2>=n || c1>=n || c2>=n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        
        if(dp[r1][c1][r2][c2]!=0) {
            return dp[r1][c1][r2][c2];
        }
        
        if(r1 == n-1 && c1 == n-1) {
            return grid[r1][c1];
        }
        
        
        if(r2 == n-1 && c2 == n-1) {
            return grid[r2][c2];
        }
        
        if(r1 == r2 && c1 == c2) {
            cherries = grid[r1][c1];
        } else {
            cherries = grid[r1][c1] + grid[r2][c2];
        }
        
        cherries += Math.max(Math.max(backtrack(grid, r1+1, c1, r2+1,c2,dp, n),
                            backtrack(grid, r1+1, c1, r2,c2+1,dp, n)),
                    Math.max(backtrack(grid, r1, c1+1, r2+1,c2,dp, n),
                            backtrack(grid, r1, c1+1, r2,c2+1,dp, n)));
        
        dp[r1][c1][r2][c2] = cherries;
        
        return dp[r1][c1][r2][c2];
    }
    
   
}