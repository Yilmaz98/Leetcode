class Solution {
    
    public boolean isValid(int x, int y, int[][] grid, int n) {
        if(x<0 || x>=n || y<0 || y>=n || grid[x][y] == 1)
            return false;
        
        return true;
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = {{-1,0}, {0,1}, {0,-1}, {1,0}, {1,-1}, {1,1},{-1,1},{-1,-1}};
        
        if(grid[0][0] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        Set<String>visited = new HashSet<>();
        q.add(new int[]{0,0});
        
        int n = grid.length;
        visited.add(0 + "," + 0);
        
        int steps = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
            int[] curr = q.poll();
            
            if(curr[0] == n-1 && curr[1] == n-1) {
                return steps;
            }
            
            for(int[] dir : dirs) {
                int newX = curr[0] + dir[0];
                int newY = curr[1] + dir[1];
                
                if(isValid(newX, newY, grid, n) && !visited.contains(newX + "," + newY)) {
                    visited.add(newX + "," + newY);
                    q.add(new int[]{newX, newY});
                }
            } 
            }
            steps++;
        }
        
        return -1;
    }
}