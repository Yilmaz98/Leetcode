class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        
        for(int i = 0; i< m;i++) {
            for(int j = 0;j<n;j++) {
               max = Math.max(max,dfs(matrix, i, j, cache, -1, m , n));
            }
        }
        
        return max;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] cache, int prev, int m, int n) {
        if(i < 0 || i >= m || j <0 || j >= n || prev >= matrix[i][j]) {
            return 0;
        }
        
        if(cache[i][j] != 0)
            return cache[i][j];
        
       int result = 1;
       int down = 1 + dfs(matrix, i + 1, j, cache, matrix[i][j], m, n);
       int up = 1 + dfs(matrix, i - 1, j, cache, matrix[i][j], m, n);
       int right = 1 + dfs(matrix, i, j + 1, cache, matrix[i][j], m, n);
       int left = 1 + dfs(matrix, i, j - 1, cache, matrix[i][j], m, n);
        
       result = Math.max(down, Math.max(up, Math.max(left, right)));
       
       return cache[i][j] = result;
    }
}