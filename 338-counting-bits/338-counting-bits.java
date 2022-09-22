class Solution {
    public int hammingWeight(int i) {
        int count =0;
        while(i!=0) {
            i &= (i-1);
            count++;
        }
        
        return count;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        int idx = 0;
        
        for(int i=0;i<=n;i++) {
            ans[idx++] = hammingWeight(i);
        }
        
        return ans;
    }
}