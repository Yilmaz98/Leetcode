class Solution {
    int[][] dist = {{-1,0},{0,1},{0,-1},{1,0}};
    
    public void wallsAndGates(int[][] rooms) {
        for(int i = 0;i<rooms.length;i++) {
            for(int j = 0;j<rooms[0].length;j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    
    public void bfs(int[][] rooms, int i, int j) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{i,j});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            for(int k=0;k<4;k++) {
                int newX = curr[0] + dist[k][0];
                int newY = curr[1] + dist[k][1];

                
                if(newX >=0 && newX < m && newY >=0 && newY < n) {
                    if(rooms[newX][newY] > rooms[curr[0]][curr[1]] + 1) {
                         rooms[newX][newY] = rooms[curr[0]][curr[1]]  + 1;
                    q.add(new int[]{newX, newY});
                    }
                   
                }
            }
        }
    }
}