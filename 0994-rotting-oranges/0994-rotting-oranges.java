class Solution {
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 1) {
                    freshOranges++;
                } else if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                }
            }
        }
        
        if(q.isEmpty()) {
            if(freshOranges > 0)
                return -1;
            else 
                return 0;
        }
        
        if(freshOranges == 0)
            return 0;
        
        int time = 0;
        int minutes = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();    
            minutes++;
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                
                for(int[] dir : dirs) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    
                    if(newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        q.add(new int[]{newX, newY});
                        freshOranges--;
                    }
                }
            }
            if(freshOranges == 0) 
                return minutes;
        }
        
        if(freshOranges != 0)
            return -1;
        
        return minutes;
    }
}