class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        int[] result = new int[spells.length];
        int index = 0;
        for(int i= 0;i<spells.length;i++) {
            int pairs = 0;
            int low = 0;
            int high = potions.length - 1;
            
            while(low < high) {
                int mid = low + (high-low)/2;
                long curr = potions[mid] * (long) spells[i];
                if(curr < success) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            
            if(low == potions.length - 1) {
                long mult = potions[low] * (long) spells[i];
                
                if(mult >= success) {
                    pairs += 1;
                }
            } else 
                pairs += (potions.length - low);
            result[index++] = pairs;
        }
        
        return result;
    }
}