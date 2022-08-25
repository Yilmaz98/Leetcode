class Solution {
    public int partition(int[] weights, int capacity) {
        int count = 1;
        int sum = 0;
        for(int i=0;i<weights.length;i++) {
            if(sum > capacity) {
                count = weights.length;
                break;
            }
                
            if(sum + weights[i] > capacity) {
                count++;
                sum = 0; 
            }   
            sum += weights[i];
        }
        return count;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = 0;
        for(int i=0;i<weights.length;i++) {
            sum += weights[i];  
            max = Math.max(max, weights[i]);
        }    
        int low = 0;
        int high = sum;
        
        while(low < high) {
            int mid = low + (high-low)/2;  
            //System.out.println(mid);
            if(partition(weights,mid) <= days) {
                high = mid;
            } else {
                  low = mid+1;
            }            
        }
        
        if(low == 0)
            return max;
        
        return low;
    }
}