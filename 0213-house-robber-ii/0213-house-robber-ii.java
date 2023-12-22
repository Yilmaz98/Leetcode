class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        
        int ans = robFirst(nums, 0, n - 2);
        int ans2 = robFirst(nums, 1, n - 1);
                
        return Math.max(ans, ans2);
    }
    
     public int robFirst(int[] nums, int start, int end) {
        int n = nums.length;     
        
        int pick = 0;
        int notPick = 0;
        
        int nextNext = nums[end];
        int next = nums[end];
        int curr = nums[end];
        
        for(int i = end - 1;i>=start;i--) {
            pick = nums[i] + (i + 2 >= end + 1 ? 0 : nextNext);
            notPick =  (i + 1 >= end + 1 ? 0 : next);
            
            curr = Math.max(pick, notPick);
            nextNext = next;
            next = curr;
        }
        
        return curr;
    }
}