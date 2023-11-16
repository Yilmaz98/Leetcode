class Solution {
    int[][] dir = {{-1,0},{0,1},{1,0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                } else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
            if(q.isEmpty()) {
                if(freshOranges>0)
                    return -1;
                else
                    
            return 0;
            }
        
        int time = 0;
        while(!q.isEmpty()) {
            int size = q.size();            
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                
                for(int[] nei : dir) {
                    int newX = curr[0] + nei[0];
                    int newY = curr[1] + nei[1];
                    
                    if(newX >=0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        freshOranges--;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
            time++;
        }
        

        
        if(freshOranges > 0)
            return -1;
        
        return time - 1;
    }
}