class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
    
    public boolean isValid(int newX, int newY, int m, int n, int[][] visited, int[][] grid) {
        if(newX >=0 && newX < m && newY >=0 && newY < n && visited[newX][newY] == 0 && grid[newX][newY] == 0)
            return true;
        return false;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0)
            return 0;
            
        if(grid[0][0] == 1)
            return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] visited = new int[m][n];
        
        visited[0][0] = 1;
        int steps = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            steps++;
            for(int j = 0;j<size;j++) {
                int[] curr = q.poll();
                
                if(curr[0] == m - 1 && curr[1] == n -1)
                    return steps;
            
                for(int i=0;i<8;i++) {
                    int newDirX = curr[0] + dirs[i][0];
                    int newDirY = curr[1] + dirs[i][1];

                    if(isValid(newDirX, newDirY, m, n, visited, grid)) {
                        q.add(new int[]{newDirX, newDirY});
                        visited[newDirX][newDirY] = 1;
                    }
                }
            }
        }
        
        return -1;
    }
}