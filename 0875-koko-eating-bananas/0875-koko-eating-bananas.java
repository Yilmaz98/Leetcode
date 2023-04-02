class Solution {
    public int computeHours(int mid, int piles[]) {
        int hours = 0;
        for(int i=0;i<piles.length;i++) {
                hours += (Math.ceil((double)piles[i]/mid));
        }
        
        return hours;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        Arrays.sort(piles);
        int high = piles[piles.length - 1];
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            int hours = computeHours(mid,piles);
            if(hours <= h) {
                high = mid;
            } else if(hours > h) {
                low = mid+1;
            }
        }
        
        return high;
    }
}