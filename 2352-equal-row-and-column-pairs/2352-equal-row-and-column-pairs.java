class Solution {
    public boolean isEqual(int[] a, int [] b) {
        for(int i=0;i<a.length;i++) {
            if(a[i] != b[i])
                return false;
        }
        return true;
    }
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        
        int[][] transposedMatrix = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                transposedMatrix[i][j] = grid[j][i];
            }
        }
        
        int ans = 0;
        
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(isEqual(grid[i], transposedMatrix[j]))
                    ans++;
            }
        }
        
        return ans;
    }
}