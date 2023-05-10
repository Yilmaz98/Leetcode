class Solution {
    int num = 1;
    public void dfs(int[][] arr, int i, int j, boolean[][] visited, boolean up) {
        if(i<0 || i>=arr.length || j<0 || j>= arr[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        arr[i][j] = num;
        num++;
        
        if(up) {
            dfs(arr,i-1,j, visited, true);
        }
        
        dfs(arr,i,j+1, visited, false);
        dfs(arr,i+1,j, visited, false);
        dfs(arr,i,j-1, visited, false);
        dfs(arr,i-1,j, visited, true);
    } 
    
    public int[][] generateMatrix(int n) {
        int[][] arr = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        dfs(arr, 0, 0, visited, false);
        return arr;
    }
}