class Solution {
    public long canFinishEating(int[] piles, int h) {
        long count = 0;
        
        for(int i=0;i<piles.length;i++) {
            count += Math.ceil((double) piles[i] /h);
        }
        
        return count;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        
        int maxi = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) {
            maxi = Math.max(maxi, piles[i]);
        }
        
        int low = 0;
        int high = maxi;
        int ans = - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(canFinishEating(piles, mid) > h) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        
        return ans;
    }
}