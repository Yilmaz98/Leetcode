class Solution {
    int x[] = {-1,0,0,1};
    int y[] = {0,-1,1,0};
    public class Node {
        int x;
        int y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public boolean isSafe(int r, int c, char[][] grid,int m, int n) {
        if(r<0 || r>=m || c<0 || c>=n || grid[r][c] == '0') {
            return false;
        }
        return true;
    }
    
    public void bfs(char[][] grid, int i, int j, int m, int n) {
        Queue<Node> qu = new LinkedList<>();
        qu.offer(new Node(i,j));
        while(!qu.isEmpty()) {
            Node nu = qu.poll();
            for(int k=0;k<4;k++) {
                int nr = nu.x + x[k]; 
                int nc = nu.y + y[k]; 
                if(isSafe(nr,nc,grid, m,n)) {
                    grid[nr][nc] = '0';
                    qu.offer(new Node(nr,nc));
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;        
        int count = 0;
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(grid[i][j] == '1') {
                    bfs(grid,i,j,m,n);
                    count++;
                }
            }
        }
        return count;
    }
}