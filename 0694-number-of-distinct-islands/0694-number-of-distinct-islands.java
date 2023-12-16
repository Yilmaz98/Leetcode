class Solution {
    int[][] dirs = {{1,0}, {-1,0},{0,1},{0,-1}};
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> result = new HashSet<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    result.add(bfs(grid, i, j, m, n));
                }
            }
        }
        
        return result.size();
    }
    
    public String bfs(int[][] grid, int i, int j, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++) {
                int[] curr = q.poll();
                
                for(int[] dir : dirs) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    
                    
                    if(newX >=0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 0;
                        sb.append((newX - i) + " " + (newY - j));
                        q.add(new int[]{newX, newY}); 
                    }
                }
            }
        }
        
        return sb.toString();
    }
}