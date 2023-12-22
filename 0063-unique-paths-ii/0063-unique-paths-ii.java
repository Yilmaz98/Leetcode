class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
       
        if(obstacleGrid[m-1][n-1] == 1)
            return 0;
        
        int[][] dp = new int[m][n];
        
        int right = 0;
        int down = 0;
        
        for(int i = m - 1;i>=0;i--) {
            for(int j = n - 1;j>=0;j--) {
                if(i == m-1 && j == n-1) {
                    dp[i][j] = 1;
                }
                else if(obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    right = 0;
                    down = 0;
                    
                    right = j + 1 < n ? dp[i][j+1] : 0;
                    down = i + 1 < m ? dp[i+1][j] : 0;
                    
                    dp[i][j] = down + right;
                }
                
            }
        }
        
        return dp[0][0];
    }
}