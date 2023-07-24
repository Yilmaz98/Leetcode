class Solution {
    int[][] dirs = {{-1,0},{0,1},{0,-1},{1,0}};
    boolean isValid(int x, int y, int m, int n) {
        if(x>=0 && x<m && y>=0 && y<n)
            return true;
        return false;
    }
    
    boolean isObstacle(int x, int y, int[][] grid) {
        return grid[x][y] == 1;
    }
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        if(k > m+n-2)
            return m+n-2;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,k});
        boolean[][][] visited = new boolean[m][n][k+1];
        
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {        
                int[] curr = q.poll();
                
                
                if(curr[0] == m-1 && curr[1] == n-1) {
                    return steps;
                }
                
                for(int[] dir : dirs) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    int currK = curr[2];
                    
                    if(isValid(newX, newY,m,n) && !visited[newX][newY][currK]) {
                        if(isObstacle(newX,newY,grid)) {
                            if(currK-1<0)
                                continue;
                            visited[newX][newY][currK] = true;
                            q.add(new int[]{newX,newY,currK-1});
                        } else{
                            visited[newX][newY][currK] = true;
                            q.add(new int[]{newX,newY,currK});
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1;
    }
}