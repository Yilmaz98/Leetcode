class Solution {
    int x[] = {-1,-1,-1,0,0,1,1,1};
    int y[] = {-1,0,1,1,-1,-1,1,0};
    
    public class Node {
        int x;
        int y;
        int dist;
        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public boolean isSafe(int x, int y, int m, int n, int[][] grid, boolean[][] visited) {
        if(x<0 || x>=n || y<0 || y>=n || grid[x][y] == 1 || visited[x][y]) {
            return false;
        }
        
        return true;
    }
    
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        
        PriorityQueue<Node> q = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        q.offer(new Node(0,0,1));
        
        
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        
        dist[0][0] = 1;
        
        while(!q.isEmpty()) {
            Node no = q.poll();
            int currX = no.x;
            int currY = no.y;
            visited[currX][currY] = true;
            for(int i=0;i<8;i++) {
                int newX = currX + x[i];
                int newY = currY + y[i];
                if(isSafe(newX,newY,m,n, grid, visited)) {
                    if(no.dist + 1 < dist[newX][newY]) {
                        dist[newX][newY] = no.dist + 1;
                        q.offer(new Node(newX,newY,dist[newX][newY]));
                    }
                }
            }
        }
        
        if(dist[m-1][n-1]  == Integer.MAX_VALUE)
            return -1;
        return dist[m-1][n-1];
    }
}