class Solution {
    public int getMaximumGold(int[][] grid) {
        
    	int goldMax = 0;
    	for (int i=0; i<grid.length; i++) {
    		for (int j=0; j<grid[0].length; j++) {
    			goldMax = Math.max(goldMax, helper(grid, i, j));
    		}
    	}
    	return goldMax;
    }

	private int helper(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || grid.length-1 < i  || grid[0].length-1 < j || grid[i][j] == 0) {
            return 0;
        }
		int tmp = grid[i][j];
		grid[i][j]=0;
		
		int up = tmp + helper(grid, i-1, j);
        int down =  tmp + helper(grid, i+1, j);
		int left = tmp + helper(grid, i, j-1);
		int right = tmp + helper(grid, i, j+1);
		
		grid[i][j]=tmp;
		
		return Math.max(Math.max(Math.max(left, right), up), down);
	}
}