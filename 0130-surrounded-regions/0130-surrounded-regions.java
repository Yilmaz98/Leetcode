class Solution {
    public void solve(char[][] board) {
        // boundary start dfs
        int m = board.length;
        int n = board[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(i ==0 || i == m - 1 || j == 0 || j == n-1) {
                    if(board[i][j] == 'O') {
                        if(!visited[i][j])
                            dfs(board,i,j,visited,m,n);
                    }
                }
            }
        }
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O') {
                    if(!visited[i][j]) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }
    
    
    public void dfs(char[][] board, int i, int j, boolean[][] visited, int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >=n || board[i][j] == 'X' || visited[i][j])
            return;
        
        visited[i][j] = true;
        dfs(board,i+1,j,visited,m,n);
        dfs(board,i,j+1,visited,m,n);
        dfs(board,i-1,j,visited,m,n);
        dfs(board,i,j-1,visited,m,n);
    }
}