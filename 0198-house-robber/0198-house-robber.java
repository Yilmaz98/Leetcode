class Solution {
    public int rob(int[] nums) {
        int n = nums.length;     
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return recurse(nums, 0, n, dp);
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