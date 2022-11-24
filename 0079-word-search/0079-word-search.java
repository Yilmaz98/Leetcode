class Solution {
    boolean found;
    public void dfs(int i, int j, char[][] board, String word, int k, boolean[][] visited) {
        if(k >= word.length())
        {
            found = true;
            return;
        }
        
        if(i<0 || i>board.length-1 || j<0 || j> board[0].length-1 || visited[i][j] || board[i][j] != word.charAt(k)) {
            return;
        }
          
        visited[i][j] = true;
        
        dfs(i,j+1,board,word,k+1,visited);
        dfs(i,j-1,board,word,k+1,visited);
        dfs(i+1,j,board,word,k+1,visited);
        dfs(i-1,j,board,word,k+1,visited);
        
          visited[i][j] = false;
    }
    
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        boolean visited[][];
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                visited = new boolean[m][n];
                found = false;
                dfs(i,j,board,word,0,visited);
                if(found)
                    return true;
            }
        }
        
        return false;
    }
}