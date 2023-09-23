class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m+1][m+1];
        
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return backtrack(triangle, m-1, 0, m, dp);
    }
    
    public int backtrack(List<List<Integer>> triangle, int row, int col, int m, int[][] dp) {
        if(row == 0 && col == 0)
            return triangle.get(row).get(col);
        
        if(col < 0 || row < 0 || col >= triangle.get(row).size())
            return 100000;
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int mini = Integer.MAX_VALUE;
        int curr = 0;
        
        if(row == m-1)  {
             for(col = 0;col < triangle.get(row).size();col++) {
                int up = triangle.get(row).get(col) + backtrack(triangle, row - 1, col,m,dp);
                int diagonal = triangle.get(row).get(col) + backtrack(triangle, row - 1, col - 1,m,dp);
                        
                curr = Math.min(up, diagonal);
                mini = Math.min(mini, curr);
        }
        } else {
            int up = triangle.get(row).get(col) + backtrack(triangle, row - 1, col,m,dp);
            int diagonal = triangle.get(row).get(col) + backtrack(triangle, row - 1, col - 1,m,dp);
            
            curr = Math.min(up, diagonal);
            mini = Math.min(mini, curr);
        }
        
        return dp[row][col] = mini;
    }
}