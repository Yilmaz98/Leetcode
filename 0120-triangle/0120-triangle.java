class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        
        int down = Integer.MAX_VALUE;
        int diagonal = Integer.MAX_VALUE;
        
        for(int i = m-1;i>=0;i--) {
            for(int j = triangle.get(i).size() - 1;j>=0;j--) {
                if(i == m- 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    down = Integer.MAX_VALUE;
                    diagonal = Integer.MAX_VALUE;
                    
                    if(i + 1 < m) 
                        down = triangle.get(i).get(j) + dp[i+1][j];
                    
                    if(i + 1 < m && j + 1 < triangle.get(i+1).size()) 
                        diagonal = triangle.get(i).get(j) + dp[i+1][j+1];
                    
                    dp[i][j] = Math.min(down, diagonal);
                }
            }
        }
        
        return dp[0][0];
    }
}