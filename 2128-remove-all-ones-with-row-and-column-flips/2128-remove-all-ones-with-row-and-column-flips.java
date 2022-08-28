class Solution {
    public boolean arrayEquals(int[]a, int[] b){
        for(int i=0;i<a.length;i++) {
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }
    public boolean removeOnes(int[][] grid) {
        int[] real = grid[0];
        int[] flipped = new int[grid[0].length];
        
        for(int i=0;i<real.length;i++) {
            flipped[i] = 1 - real[i];
        }
        
        for(int i=0;i<grid.length;i++) {
            if(!arrayEquals(grid[i],real) && !arrayEquals(grid[i],flipped))
                return false;
        }
        
        return true;
    }
}