class Solution {
    int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    public void dfs(char[][] grid, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = '0';
        q.add(new int[]{i,j});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            for(int[] newZ : dir) {
                int newX = newZ[0] + curr[0];
                int newY = newZ[1] + curr[1];
                
                if(newX >=0 && newX<grid.length && newY>=0 && newY < grid[0].length && grid[newX][newY] == '1'){
                    grid[newX][newY] = '0';
                    q.add(new int[]{newX, newY});
                }
            }
        }
    }
}