class Solution {
    
    public int capacity(int weight, int[] weights) {
        int sum = 0;
        int days = 1;
        
        for(int i=0;i<weights.length;i++) {
            if(sum > weight)
                return weights.length;
            
            if(sum + weights[i] > weight) {
                days++;
                sum = 0;
            }
                
            sum += weights[i];
        }
        
        return days;
    }
    
    public int shipWithinDays(int[] weights, int days) {        
        int totalWeight = 0;
        int max = 0;
        
        for(int i=0;i<weights.length;i++) {
            totalWeight += weights[i];
            max = Math.max(max, weights[i]);
        }
        
        int low = 0;
        int high = totalWeight;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if(capacity(mid, weights) > days) {
                low = mid + 1; 
            } 
            else {
                high = mid;
            } 
        }
        
        if(low == 0)
            return max;
        
        return low;
    }
}