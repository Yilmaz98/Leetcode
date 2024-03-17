class Solution {  
    int[][] cache;
    public int dfs(int[][] matrix, int i, int j, int m, int n) {        
        if(cache[i][j] != 0)
            return cache[i][j];
        
        int down = 0;
        int up = 0;
        int right = 0;
        int left = 0;
        
        if(i+1<m && matrix[i+1][j] > matrix[i][j])
            down = 1 + dfs(matrix,i+1,j,m,n);
        if(i-1>=0 && matrix[i-1][j] > matrix[i][j])
            up = 1 + dfs(matrix,i-1,j,m,n);
        if(j+1<n && matrix[i][j+1] > matrix[i][j])
            right  = 1 + dfs(matrix,i,j+1,m,n);
        if(j-1>=0 && matrix[i][j-1] > matrix[i][j])
            left = 1 + dfs(matrix,i,j-1,m,n);
        
        return cache[i][j] = Math.max(left, Math.max(right, Math.max(up, down)));
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLength = 0;
        cache = new int[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                maxLength = Math.max(maxLength, dfs(matrix,i,j,m,n));
            }
        }
        
        return 1 + maxLength;
    }
}