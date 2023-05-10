class Solution {
    List<Integer> result = new ArrayList<>();
      public void dfs(int[][] arr, int i, int j, boolean[][] visited, boolean up) {
        if(i<0 || i>=arr.length || j<0 || j>= arr[0].length || visited[i][j]) {
            return;
        }
          
        visited[i][j] = true;
          result.add(arr[i][j]);
          
          System.out.println(i + ":" + j);
        
        if(up) {
            dfs(arr,i-1,j, visited, true);
        }
        
        dfs(arr,i,j+1, visited, false);
        dfs(arr,i+1,j, visited, false);
        dfs(arr,i,j-1, visited, false);
        dfs(arr,i-1,j, visited, true);
    } 
    
    
    public List<Integer> spiralOrder(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;
    boolean[][] visited = new boolean[m][n];
        
    dfs(arr, 0, 0, visited, false);
        
        return result;
    }
}