class Solution {
    int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        for(int i=0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(rooms[i][j] == 0) {
                    bfs(i, j, rooms,m,n);
                }
            }
        }
    }
    
    public void bfs(int i, int j, int[][] rooms,int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            
            for(int k=0;k<4;k++) {
                int newX = x + dir[k][0];
                int newY = y + dir[k][1];
                
                if(newX >= 0 && newX < m && newY >= 0 && newY < n && rooms[newX][newY] > rooms[x][y] + 1) {
                    rooms[newX][newY] = rooms[x][y] + 1;
                    q.add(new int[]{newX, newY});
                }
            }
        }
    }
}