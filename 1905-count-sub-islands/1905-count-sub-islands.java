class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int m = grid2.length;
        int n = grid2[0].length;
        
        int countsub = 0;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if (dfs(grid1, grid2, i, j, visited) == true) {
                        countsub++;
                    }
                }
            }
        }
        return countsub;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[i].length 
            || grid2[i][j] != 1 || visited[i][j]) {
            return true;
        }
        if (grid1[i][j] != grid2[i][j]) {
            return false;
        }
        visited[i][j] = true;
        
        boolean left = dfs(grid1, grid2, i - 1, j, visited);
        boolean right = dfs(grid1, grid2, i + 1, j, visited);
        boolean up = dfs(grid1, grid2, i, j + 1, visited);
        boolean down = dfs(grid1, grid2, i, j - 1, visited);
            
        return left && right && up && down;
    }
}