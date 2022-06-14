class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n+1];

        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[0][n-1] = triangle.get(0).get(0);
        
        
        for(int i=1;i<n;i++) {
            int k = 0;
            for(int j=n-1-i;j<n;j++) {
                
      dp[i][j] = triangle.get(i).get(k) + Math.min(dp[i-1][j], dp[i-1][j+1]);
                k++;
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(dp[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        int ans = Integer.MAX_VALUE;
            for(int j=0;j<n; j++){
                ans = Math.min(ans, dp[n-1][j]);
        }
        
        return ans;
    }
}