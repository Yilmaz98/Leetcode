class Solution {
    int[] dirX = {-1,0,0,1};
    int[] dirY = {0,1,-1,0};
    
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        
        pq.add(new int[]{0,0,0});
        
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        int[][] dist = new int[m][n];
        dist[0][0] = heights[0][0];
        
        for(int i=0;i<m;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        while(!pq.isEmpty()) {
            int size = pq.size();
            
            for(int i=0;i<size;i++) {
                int[] curr = pq.poll();
                
                visited[curr[0]][curr[1]] = true;
                
               
                
                for(int j=0; j<4;j++) {
                    int newX = curr[0] + dirX[j];
                    int newY = curr[1] + dirY[j];
                    
                    if(newX < m && newX >=0 && newY<n && newY>=0 && !visited[newX][newY]) {
                        
                        int dis = Math.max(curr[2], Math.abs(heights[newX][newY] - heights[curr[0]][curr[1]]));
                        
                        if(dis < dist[newX][newY]) {
                            dist[newX][newY] = dis;
                        }
                        pq.add(new int[]{newX,newY,dis});
                    }
                }
            }
        }
        
        return dist[m-1][n-1] == Integer.MAX_VALUE ? 0 : dist[m-1][n-1];
    }
}