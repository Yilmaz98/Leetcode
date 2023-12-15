class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0, 1}, {0,-1}};
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        int[][] visited = new int[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if(board[i][j] == 'O') {
                        q.add(new int[]{i,j});
                        visited[i][j] = 1;
                    }
                }
            }
        }
        
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                int[] curr = q.poll();
                
                for(int[] dir : dirs) {
                    int newX = curr[0] + dir[0];
                    int newY = curr[1] + dir[1];
                    
                    if(newX >=0 && newX < m && newY >= 0 && newY < n && board[newX][newY] == 'O' && visited[newX][newY] == 0) {
                        visited[newX][newY] = 1;
                        q.add(new int[]{newX, newY});
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}