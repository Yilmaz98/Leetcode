class Solution {
    public int minPathSum(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return bfs(grid,0,0,grid.length,grid[0].length,visited);
    }
    
    int[][] dirs = {{0,1},{1,0}};
    
    public int bfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        
        int minPath = Integer.MAX_VALUE;
        
        q.add(new int[]{i,j,grid[i][j]});
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++) {
                int curr[] = q.poll();
                
                if(curr[0] == m-1 && curr[1] == n-1) {
                    minPath = Math.min(minPath, curr[2]);
                }
               for(int[] dir: dirs) {
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                
                   if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc]) {
                       visited[nr][nc] = true;
                       q.add(new int[]{nr,nc,curr[2] + grid[nr][nc]});
                   }
                }   
            }
        }
        
        
        return minPath;
      
    }
}