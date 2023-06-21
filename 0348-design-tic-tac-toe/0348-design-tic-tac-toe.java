class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antidiagonal;
    int n;
    
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int curr = (player == 1) ? 1 : -1;
        
        rows[row] += curr;
        cols[col] += curr;
        
        if(row == col) {
            diagonal += curr;
        }
        
        if(row + col == cols.length - 1) {
            antidiagonal += curr;
        }
        
        if(Math.abs(rows[row]) == n || Math.abs(cols[col])  == n || Math.abs(diagonal) == n || Math.abs(antidiagonal) == n) {
            return player;
        }
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */