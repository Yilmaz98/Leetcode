class Solution {
    public void dfs(int[][] grid, int i, boolean[] visited) {
       for(int j = 0;j<grid[i].length;j++) {
           if(i!=j && grid[i][j] == 1 && !visited[j]) {
               visited[j] = true;
               dfs(grid,j,visited);
           }
       }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] visited = new boolean[isConnected.length];
        
        for(int i=0;i<isConnected.length;i++) {     
            if(!visited[i]) {
                visited[i] = true;
                dfs(isConnected,i,visited); 
                ans++;
            }
        }
        
        return ans;
    }
}