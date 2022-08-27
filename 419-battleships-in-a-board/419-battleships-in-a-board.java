class Solution {
    public int countBattleships(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 'X') {
                    dfs(i,j,m,n,grid);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    
    public void dfs(int i, int j, int m, int n,  char[][] grid) {
        if(i<0 || i>= m || j< 0 || j>=n || grid[i][j] == '.')
            return;
        
        grid[i][j] = '.';
        
        dfs(i+1, j, m,n,grid);
        dfs(i,j+1, m,n,grid);
        
        return; 
    }
}