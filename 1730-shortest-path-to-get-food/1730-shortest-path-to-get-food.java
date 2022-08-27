

class Node {
    int x;
    int y;
    int d;
    
    Node(int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

class Solution {   
    int[] dirX = {-1,1,0,0};
int[] dirY = {0,0,1,-1};
    public int bfs(Node source, char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Node> q = new LinkedList<>();
        q.offer(source);
        visited[source.x][source.y] = true;
        
        while(!q.isEmpty()) {
            int len = q.size();
            for(int j=0;j<len;j++) {
                  Node curr = q.poll();
            if(grid[curr.x][curr.y] == '#') {
                return curr.d;
            }
            
            for(int i=0;i<4;i++) {
                int newDirX = curr.x + dirX[i];
                int newDirY = curr.y + dirY[i];
                if(newDirX < grid.length && newDirY < grid[0].length && newDirX >=0 && newDirY>=0 && !visited[newDirX][newDirY] && grid[newDirX][newDirY] !='X') {
                    visited[newDirX][newDirY] = true;
                    q.offer(new Node(newDirX, newDirY,curr.d+1));
                }
            }   
            }
          
        }
        
        return -1;
    }
    public int getFood(char[][] grid) {
        Node source = null;
        
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == '*') {
                    source = new Node(i,j,0);
                    break;
                 }
            }
        }
        
        return bfs(source, grid);
    }
}