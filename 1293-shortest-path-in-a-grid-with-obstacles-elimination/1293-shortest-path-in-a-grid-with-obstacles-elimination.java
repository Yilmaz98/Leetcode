class Solution {
    int dirX[] = {-1,1,0,0};
    int dirY[] = {0,0,-1,1};
    
    public int bfs(int[][] grid, int m, int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,k});
        boolean[][][] visited = new boolean[m][n][k+1];
        int steps = 0;
        while(!q.isEmpty()) {
        int size = q.size();
        for(int j=0;j<size;j++) {
            int[] curr = q.poll();
          if(curr[0] == m-1 && curr[1] == n-1)
              return steps;
            
            for(int i=0;i<4;i++) {
              int newX = curr[0] + dirX[i];
              int newY = curr[1] + dirY[i];
              int obs = curr[2];                
             if(newX>=0 && newX < m && newY >= 0 && newY< n && obs>=0 && !visited[newX][newY][obs]) {
                  visited[newX][newY][obs] = true;
                 if(grid[newX][newY] == 1) {
                    q.add(new int[]{newX,newY, obs - 1}); 
                 } else {
                     q.add(new int[]{newX,newY,obs}); 
                 } 
             }
            }
                    
          }
            steps++;   
        }
        return -1;
    }
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        
        return bfs(grid, m,n,k);
    }
}