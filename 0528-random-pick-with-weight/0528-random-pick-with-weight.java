class Solution {
    public int[] prefixSums;
    public int totalSum;
    
    public Solution(int[] w) {
        prefixSums = new int[w.length];
        for(int i = 0;i<w.length;i++) {
            this.prefixSums[i] =  i > 0 ? prefixSums[i-1] + w[i] : w[i];
            this.totalSum += w[i];
        }
    }
    
    public int pickIndex() {
        double target = Math.random() * totalSum;
        
        for(int i = 0;i<prefixSums.length;i++) {
            if(target < prefixSums[i]) {
                return i;
            }
        }
        
        return 0;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */