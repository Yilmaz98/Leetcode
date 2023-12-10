class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(word.charAt(0) == board[i][j]) {
                if(backtrack(board, i, j, m, n, word, 0))
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean backtrack(char[][] board, int i, int j, int m, int n, String word, int idx) { 
        if(idx >= word.length()) {
            return true;
        }
        
        if(i < 0 || i >= m || j < 0 || j >= n || word.charAt(idx) != board[i][j])
            return false;
        
        for(int k=0;k<dir.length;k++) {
                char temp = board[i][j];
                board[i][j] = ' ';
                if(backtrack(board, i + dir[k][0], j + dir[k][1], m, n, word, idx+1))
                    return true;
                board[i][j] = temp;
        }
        
        return false;
    }
}