class Solution {
    public void dfs(char[][] board, int i, int j, int m, int n, Set<String>visited,Set<String> cells ) {
        if(i<0 || i>=m || j<0 || j>=n || visited.contains(i+"," + j) || board[i][j] == 'X') {
            return;
        }
        
        visited.add(new String(i + "," + j));
        cells.add(new String(i + "," + j));

        
        dfs(board,i+1,j,m,n,visited,cells);
        dfs(board,i,j+1,m,n,visited,cells);
        dfs(board,i-1,j,m,n,visited,cells);
        dfs(board,i,j-1,m,n,visited,cells);
    }
    
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        Set<String> cells = new HashSet<>();
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if((i==0 || i == m-1 || j == 0 || j == n-1) && (board[i][j] == 'O'))  
                    dfs(board, i, j, m,n,new HashSet<>(), cells);
            }
        }
        
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == 'O')  {
                   if(!cells.contains(i+","+j)) {
                       board[i][j] = 'X';
                   } 
                }
                   
            }
        }
    }
}