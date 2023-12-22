class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return recurse(triangle, 0, 0, m, dp);
    }
    
    public int recurse(List<List<Integer>> triangle, int i, int j, int m, int[][] dp) {
        if(i == m -1) {
            return triangle.get(i).get(j);
        }
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int down = Integer.MAX_VALUE;
        int diagonal = Integer.MAX_VALUE;
        
        if(i + 1 < m)
            down = triangle.get(i).get(j) +  recurse(triangle, i + 1, j, m, dp);
        if(i + 1 < m && j + 1 < triangle.get(i + 1).size())
            diagonal = triangle.get(i).get(j) +  recurse(triangle, i + 1, j + 1, m, dp);
        
        return dp[i][j] = Math.min(down, diagonal);
    }
}