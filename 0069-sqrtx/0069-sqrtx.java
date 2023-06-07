class Solution {
    public int mySqrt(int x) {
        
        if(x == Integer.MAX_VALUE)
            return 46340;
        
       int low = 1;
        int high  = x + 1;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if(mid > x /mid)
                high = mid;
            else 
                low = mid + 1;
        }
        
        return low - 1;
    }
}