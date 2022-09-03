class Solution {
   public int longestLine(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0){
            return 0;
        }
        int m = M.length, n = M[0].length;
        int max = 0;
        int[][][] dp = new int[m][n][4];
        for(int i = 0 ; i < m; i++){
            for(int j = 0; j < n; j++){
                if(M[i][j] == 1){
                    Arrays.fill(dp[i][j], 1);
                    if(i > 0){
                        dp[i][j][0] = dp[i - 1][j][0] + 1;
                    }
                    if(j > 0){
                        dp[i][j][1] = dp[i][j - 1][1] + 1;
                    }
                    if(i > 0 && j > 0){
                        dp[i][j][2] = dp[i - 1][j - 1][2] + 1;
                    }
                    if(i > 0 && j < n - 1){
                        dp[i][j][3] = dp[i - 1][j + 1][3] + 1;
                    }
                    int can1 = Math.max(dp[i][j][0], dp[i][j][1]);
                    int can2 = Math.max(dp[i][j][2], dp[i][j][3]);
                    max = Math.max(max, Math.max(can1, can2));
                }
            }
        }
        return max;
    }
}