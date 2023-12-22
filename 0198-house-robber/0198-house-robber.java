class Solution {
    public int rob(int[] nums) {
        int n = nums.length;     
        
        int pick = 0;
        int notPick = 0;
        
        int nextNext = nums[n-1];
        int next = nums[n-1];
        int curr = nums[n-1];
        
        for(int i = n - 2;i>=0;i--) {
            pick = nums[i] + (i + 2 >= n ? 0 : nextNext);
            notPick =  (i + 1 >= n ? 0 : next);
            
            curr = Math.max(pick, notPick);
            nextNext = next;
            next = curr;
        }
        
        return curr;
    }
}