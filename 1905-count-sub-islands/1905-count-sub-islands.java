class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int m = grid2.length;
        int n = grid2[0].length;
        
        int countsub = 0;
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if (dfs(grid1, grid2, i, j, visited)) {
//                         int sub_island_size = get_island_size(i, j, grid2);
//                         int parent_island_size = get_island_size(i, j, grid1);
                        
//                         System.out.println(sub_island_size + ":" + parent_island_size);
                        
//                         if((sub_island_size/parent_island_size) * 100 >= 40)
                            countsub += 1;
                    }
                }
            }
        }
        return countsub;
    }
    
    private int get_island_size(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length 
            || grid[i][j] != 1) {
            return 0;
        }
        
        grid[i][j] = -1;
        
        int count = 1;
        count += get_island_size(i - 1, j, grid);
        count += get_island_size(i + 1, j, grid);
        count += get_island_size(i, j + 1, grid);
        count += get_island_size(i, j - 1, grid);
        
        return count;
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