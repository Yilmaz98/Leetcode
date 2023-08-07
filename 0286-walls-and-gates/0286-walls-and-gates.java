class Solution {
    
    int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
    int INF = 2147483647;
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        int[][] dist = new int[m][n];
        
        for(int i=0;i<m;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        boolean[][] visited;
        
        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[0].length;j++) {
                if(rooms[i][j] == 0) {
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                    bfs(i,j, dist, m, n, rooms, visited); 
                }           
            }
        }
        
        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[0].length;j++) {
               if(dist[i][j] != INF)   {
                   rooms[i][j] = dist[i][j];
               }
            }
        } 
    }
    
    public void bfs(int x, int y, int[][] dist, int m, int n, int[][] rooms,   boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x,y});
        dist[x][y] = 0; 
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
                      
            for(int i=0;i<4;i++) {
                int newX = curr[0] + dir[i][0];
                int newY = curr[1] + dir[i][1];
                
                if(newX >=0 && newX < m && newY >= 0 && newY < n && rooms[newX][newY] == INF && !visited[newX][newY] && dist[curr[0]][curr[1]] + 1 < dist[newX][newY] ) {
                    dist[newX][newY] = dist[curr[0]][curr[1]] + 1;
                    q.add(new int[]{newX,newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }
}