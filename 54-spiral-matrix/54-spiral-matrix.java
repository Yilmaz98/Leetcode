class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(matrix,0,0,m,n,false, visited);
        return result;
    }
    
    public void dfs(int[][] matrix,int i, int j, int m, int n, boolean up, boolean[][] visited) {
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] == true) {
            return;
        }
        visited[i][j] = true;
        result.add(matrix[i][j]);
        if(up) {
            dfs(matrix,i-1,j,m,n,true,visited); 
        }
        dfs(matrix,i,j+1,m,n,false,visited);
        dfs(matrix,i+1,j,m,n,false,visited);
        dfs(matrix,i,j-1,m,n,false,visited);
        dfs(matrix,i-1,j,m,n,true,visited);
    }
}