class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        
        int[][] dist = new int[m][n];
        
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        q.add(new int[]{0,0,0});
        
        for(int i=0;i<m;i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        dist[0][0] = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int k = 0;k<size;k++) {
                int[] curr = q.poll();
                
                visited[curr[0]][curr[1]] = true;
                
                if(curr[0] == m - 1 && curr[1] == n - 1)
                    return dist[curr[0]][curr[1]];
                
                
                for(int i=0;i<4;i++) {
                    int newX = curr[0] + dirs[i][0];
                    int newY = curr[1] + dirs[i][1];
                    
                    if(newX >=0 && newX < m && newY >=0 && newY < n && !visited[newX][newY]) {
                        int dis = Math.max(curr[2], Math.abs(heights[curr[0]][curr[1]] - heights[newX][newY]));
                        if(dis < dist[newX][newY])
                            dist[newX][newY] = dis;
                        q.add(new int[]{newX, newY, dis});
                    }
                }
            }
        }
        
        return -1;
    }
}