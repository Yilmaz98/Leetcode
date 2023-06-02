class Solution {
    
    int[][] moves = new int[][] {
        {2, 1}, {2,-1}, {-2,1}, {-2,-1}, {1,2}, {1,-2}, {-1,2}, {-1,-2}
    };
    public double knightProbability(int N, int steps, int initRow, int initCol) {
        // we want to prepare the memoization cache for each step and each row col
        double[][][] cache = new double[steps + 1][N+1][N+1];
        
        for (int i = 0; i <= steps; i++) {
            for (int j = 0; j <= N; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        
        return dfs(N, steps, initRow, initCol, cache);
    }
    
    private double dfs(int boardSize, int steps, int row, int col, double[][][] cache) {
        // Terminal condition
        if (!(row >= 0 && row < boardSize && col >= 0 && col < boardSize)) {
            // we are going out of boundary
            return 0;
        }
        
        if (steps == 0)
            return 1;
        
        // See if we hit the cache
        if (cache[steps][row][col] != -1)
            return cache[steps][row][col];
        
        double totalNumberOfWaysToStayInBoard = 0.0;
        
        // Go in all possible direction and collect probability of staying in the board
        for (int[] move : moves) {
            totalNumberOfWaysToStayInBoard += dfs(boardSize, steps - 1, row + move[0], col + move[1], cache);
        }
        
        double probability = totalNumberOfWaysToStayInBoard / 8.0;
        cache[steps][row][col] = probability;
        return probability;
    }
    
    
}