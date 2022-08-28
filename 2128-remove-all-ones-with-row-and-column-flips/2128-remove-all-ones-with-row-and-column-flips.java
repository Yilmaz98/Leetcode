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
        int[] flipped = Arrays.copyOf(real, real.length);
        
        for(int i=0;i<flipped.length;i++) {
            flipped[i] ^= 1;
        }
        
        for(int i=0;i<grid.length;i++) {
            if(!arrayEquals(grid[i],real) && !arrayEquals(grid[i],flipped))
                return false;
        }
        
        return true;
    }
}