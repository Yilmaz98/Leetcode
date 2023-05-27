class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i=0;i<=m;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[1][1] = triangle.get(0).get(0);
        
        for(int i=2;i<=m;i++) {
            for(int j=1;j<=triangle.get(i-1).size();j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i-1).get(j-1);
            }
        }
        
        int result = Integer.MAX_VALUE;

        
        for(int i=0;i<=n;i++) {
            result = Math.min(result, dp[m][i]);
        }
        
        return result;
    }
}