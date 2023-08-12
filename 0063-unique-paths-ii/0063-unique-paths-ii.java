class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
          int[][] memo = new int[m][n];
        return helper(memo, m, n, 0, 0, obstacleGrid);
    }
    
      public int helper(int[][] memo, int m, int n, int i, int j, int[][] grid) {
        
        if(i>=m || j >= n || i<0 || j<0 || grid[i][j] == 1){
            return 0;
        }
        
        if(i == m-1 && j == n-1){
            return memo[i][j] = 1;
        }
        
        if(memo[i][j] != 0)
            return memo[i][j];
        
        int down = helper(memo, m, n, i+1,j, grid);
        int right = helper(memo, m,n, i, j+1, grid);
        
        return memo[i][j] = down + right;
    }
}