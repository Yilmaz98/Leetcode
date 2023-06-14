class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        dfs(0,0,matrix,m, n,ans, false, new boolean[m][n]);
        
        return ans;
    }
    
    public void dfs(int i, int j, int[][] matrix, int m, int n, List<Integer> ans, boolean up, boolean[][] visited) {
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j]) {
            return;
        }
        
        ans.add(matrix[i][j]);
        visited[i][j] = true;
        
        if(up) {
            dfs(i-1,j,matrix,m,n,ans, true, visited);
        }    
        
        dfs(i,j+1,matrix,m, n,ans, false, visited);
        dfs(i+1,j,matrix,m,n,ans, false, visited);
        dfs(i,j-1,matrix,m,n,ans, false, visited);
        dfs(i-1,j,matrix,m,n,ans, true, visited);
    }
}