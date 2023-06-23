class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(!dfs(matrix, i, j, m, n, visited, matrix[i][j])) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean dfs(int[][] matrix, int i, int j, int m, int n, boolean[][] visited, int prev) {
        if(i >= m || j >=n || i<0 || j<0 || visited[i][j]) {
            return true;
        }
        
        if(matrix[i][j] != prev) {
            return false;
        }
        visited[i][j] = true;
        return dfs(matrix,i+1,j+1,m,n,visited, matrix[i][j]);
    }
}
