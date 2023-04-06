class Solution {
    public void dfs(int i, int j, int[][] grid, int m, int n) {
        if(i<0 || j<0 || i>m-1 || j>n-1 || grid[i][j] == 1)
            return;
        
        grid[i][j] = 1;
        dfs(i+1,j,grid,m,n);
        dfs(i,j+1,grid,m,n);
        dfs(i,j-1,grid,m,n);
        dfs(i-1,j,grid,m,n);
    }
    
      public void dfs2(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        if(i<0 || j<0 || i>m-1 || j>n-1 || visited[i][j] || grid[i][j] == 1)
            return;
        
        visited[i][j] = true;
          
        dfs(i+1,j,grid,m,n);
        dfs(i,j+1,grid,m,n);
        dfs(i,j-1,grid,m,n);
        dfs(i-1,j,grid,m,n);
    }
    
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if((i==0 || j==0 || i == m-1 || j == n-1) && grid[i][j] == 0)           {
                    dfs(i,j,grid, m,n);
                }
            }
        }
        
        int islands = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
               if(grid[i][j] == 0) {
                  dfs(i,j,grid, m,n);
                  islands++;
               }
            }
        }
        
        return islands;
    }
}