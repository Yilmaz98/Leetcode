class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z)
            return false;
        
        if(x == z || y == z || x + y == z)
            return true;
        
        
        return z % GCD(x,y) == 0 ? true : false;
    }
    
    public int GCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        
        return GCD(b, a % b);
    }
}