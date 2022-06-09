class Solution {
    List<Integer> res = new ArrayList<>();
    public void dfs(int[][] matrix, int i, int j, boolean[][] visited, int m,int n,  boolean up) {
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || res.size() == m*n) {
            return;
        }
        
        visited[i][j] = true;
        res.add(matrix[i][j]);
        
        if(up) {
            dfs(matrix, i-1, j, visited, m,n, true);
            dfs(matrix, i, j+1, visited, m,n,false);
        }
        
        dfs(matrix, i, j+1, visited,m,n, false);
        dfs(matrix, i+1, j, visited, m,n, false);
        dfs(matrix, i, j-1, visited, m,n,false);
        dfs(matrix, i-1, j, visited, m,n, true);
        visited[i][j] = false;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean visited[][] = new boolean[m][n];
        dfs(matrix,0,0,visited, m,n, false);
        return res;
    }
}