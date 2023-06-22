class Solution {
    public long helper(int[] ribbons, int val) {
        long count = 0;
        
        for(int i=0;i<ribbons.length;i++) {
            count += (ribbons[i]/val);
        }
        
        return count;
    } 
    
    public int maxLength(int[] ribbons, int k) {
        int low = 1;
        int high = 0;
        
        for(int i=0;i<ribbons.length;i++) {
            high = Math.max(high,ribbons[i]);
        }
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(helper(ribbons, mid) < k) {
                 high = mid -1;
            } else {
                 low = mid + 1;       
            }
        }
        
        return low > 1 ? low-1 : 0;
    }
}