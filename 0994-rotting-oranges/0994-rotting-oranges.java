class Solution {
    int[][] dirs = {{-1,0}, {0,1}, {0,-1}, {1,0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        int m = grid.length;
        int n = grid[0].length;
        
        int freshOranges = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2)
                    q.add(new int[]{i,j});
                else if(grid[i][j] == 1)
                    freshOranges++;
            }
        }
        
        int minutes = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            if(freshOranges == 0)
                return minutes;
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                
                for(int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    
                    if(newX >=0 && newX < m && newY >= 0 && newY < n) {
                        if(grid[newX][newY] == 1) {
                            freshOranges--;
                            q.add(new int[]{newX, newY});
                            grid[newX][newY] = 2;
                        }
                    }
                }
            }
            minutes++;
        }
        
        return freshOranges == 0 ? 0 : -1;
    }
}