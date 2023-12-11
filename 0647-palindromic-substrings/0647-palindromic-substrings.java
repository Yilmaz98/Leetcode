class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        boolean[][] dp= new boolean[n][n];
        int count=0;
        
        for(int gap = 0; gap < n; gap++) {
            int row = 0;
            for(int col = gap; col < n; col++) {
                if(gap == 0) {
                    dp[row][col] = true;
                }
                else if(gap == 1) {
                    if(s.charAt(row) == s.charAt(col)) {
                        dp[row][col] = true;
                    }
                }
                else {
                    if(s.charAt(row) == s.charAt(col) && dp[row+1][col-1] == true) {
                        dp[row][col] = true;
                    }
                }

                if(dp[row][col] == true) count++;
                row++;
            }
        }
        
        return count;
    }
}