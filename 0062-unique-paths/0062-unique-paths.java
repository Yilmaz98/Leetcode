class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        helper(memo, m, n, 0, 0);
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(memo[i][j] + " ");
        }
        System.out.println();
        }
        
        
        return memo[0][0];
    }
    
    public int helper(int[][] memo, int m, int n, int i, int j) {
        
        if(i>=m || j >= n){
            return 0;
        }
        
        if(i == m-1 && j == n-1){
            return memo[i][j] = 1;
        }
        
        if(memo[i][j] != 0)
            return memo[i][j];
        
        int down = helper(memo, m, n, i+1,j);
        int right = helper(memo, m,n, i, j+1);
        
        return memo[i][j] = down + right;
    }
}