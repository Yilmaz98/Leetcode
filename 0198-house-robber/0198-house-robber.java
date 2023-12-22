class Solution {
    public int rob(int[] nums) {
        int n = nums.length;     
        
        int[] dp = new int[n];
        dp[n - 1] = nums[n-1];
        
        int pick = 0;
        int notPick = 0;
        
        for(int i = n - 2;i>=0;i--) {
            pick = nums[i] + (i + 2 >= n ? 0 : dp[i + 2]);
            notPick =  (i + 1 >= n ? 0 : dp[i + 1]);
            
            dp[i] = Math.max(pick, notPick);
        }
        
        return dp[0];
    }
    
    public int recurse(int[] nums, int start, int n, int[] dp) {
        if(start == n - 1) {
            return nums[start];
        }
        
        if(start >= n)
            return 0;
        
        if(dp[start] != -1)
            return dp[start];
        
        int pick = 0;
        int notPick = 0;
        
        pick = nums[start] + recurse(nums, start + 2, n, dp);
        notPick = recurse(nums, start + 1, n, dp);
        
        return dp[start] = Math.max(pick, notPick);
    }
}