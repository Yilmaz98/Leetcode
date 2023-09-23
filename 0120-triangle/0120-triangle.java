class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m+1][m+1];
        
        for(int i=0;i<dp.length;i++) {
            Arrays.fill(dp[i], 100000);
        }
        
        dp[0][0] = triangle.get(0).get(0);
        
        for(int i = 1;i<triangle.size();i++) {
            for(int j = 0;j<triangle.get(i).size();j++) {
                
                int up = i > 0 && j < triangle.get(i).size() ? triangle.get(i).get(j) + dp[i - 1][j] : 100000;
                int diagonal = i > 0 && j > 0 ? triangle.get(i).get(j) + dp[i - 1][j - 1] : 100000;
                
                int curr = Math.min(up, diagonal);
                dp[i][j] = Math.min(dp[i][j], curr);
            }
        }
        
        int result = Integer.MAX_VALUE;
        for(int i =0;i<triangle.get(m-1).size();i++) {
            result = Math.min(result,dp[m-1][i]);
        }
        
        return result;
    }
}