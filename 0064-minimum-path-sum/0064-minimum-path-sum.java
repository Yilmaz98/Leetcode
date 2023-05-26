class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = Integer.MAX_VALUE;
        int[][] memo = new int[m][n];
        helper(0,0,grid,memo);
        
        return memo[0][0];
    }
    
    
    public int helper(int x, int y, int[][] grid, int[][] memo) {
        if(x == grid.length -1 && y == grid[0].length-1)
            return memo[x][y] = grid[x][y];
        
        if(x >= grid.length || y >= grid[0].length)
            return Integer.MAX_VALUE;
        
        if(memo[x][y] != 0) {
            return memo[x][y];
        }
        
        int result = Math.min(helper(x+1,y,grid,memo), helper(x,y+1,grid,memo)) + grid[x][y];
        
        return memo[x][y] = result;
    }
}