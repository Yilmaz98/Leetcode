class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx == tx && sy == ty)
            return true;
        
        while(tx > sx && ty > sy) {
              if(tx < ty)
                ty %= tx;
            else
                tx %= ty; 
        }
        
        if(sx == tx && sy < ty && (ty - sy) % sx ==0)
            return true;
        
        if(sy == ty && sx < tx && (tx - sx) % sy ==0)
            return true;
    
        return false;
    }
}