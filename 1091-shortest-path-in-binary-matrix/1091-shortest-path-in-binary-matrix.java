class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    
    public boolean isValid(int newX, int newY, int m, int n, Set<String> visited, int[][] grid) {
        if(newX >=0 && newX < m && newY >=0 && newY < n && !visited.contains(newX + ":" + newY) && grid[newX][newY] == 0) {
            return true;
        }
        
        return false;
    }
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if(grid[0][0] == 1)
            return -1;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        Set<String> visited = new HashSet<>();
        int steps = 0;
        
        visited.add(0 + ":" + 0);
        
        while(!q.isEmpty()) {
            int size = q.size();     
            steps++;  
            
            for(int k = 0;k<size;k++) {
                int[] curr = q.poll();
                
                if(curr[0] == m -1 && curr[1] == n -1)
                        return steps;
            
                for(int i=0;i<8;i++) {
                    int newX = curr[0] + dirs[i][0];
                    int newY = curr[1]  + dirs[i][1];

                    if(isValid(newX, newY, m, n, visited, grid)) {
                        q.add(new int[]{newX, newY});
                        visited.add(newX + ":"  + newY);
                    }
                }   
            }  
        }
        
        return -1;
    }
}