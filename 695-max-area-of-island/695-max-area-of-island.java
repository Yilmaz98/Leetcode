class Solution {
    int area;
    public void flow(int[][] grid, int i, int j, int maxArea) {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        area++;
        flow(grid,i,j+1,maxArea);
        flow(grid,i+1,j,maxArea);
        flow(grid,i,j-1,maxArea);
        flow(grid,i-1,j,maxArea);
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        area = 0;
        int maxArea = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    area = 0;
                    flow(grid,i,j, maxArea);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}