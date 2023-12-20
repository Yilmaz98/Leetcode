class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        
        for(int i=0;i<n;i++) {
           Arrays.fill(dp[i], -1); 
        }
        
        return recurse(nums, 0, -1, dp);
    }
    
    public int recurse(int[] nums, int start, int prev, int[][] dp) {
        if(start == nums.length - 1) {
            if(prev == -1 || nums[start] > nums[prev]) {
                return 1;
            } else
                return 0;
        }
        
        if(dp[start][prev + 1] != -1)
            return dp[start][prev + 1];
                
        int pick = 0;
        int notPick = 0;
        
        if(prev == -1 || nums[start] > nums[prev])
            pick = 1 + recurse(nums, start + 1, start, dp);
        
        notPick = recurse(nums, start + 1, prev, dp);
        
        return dp[start][prev + 1] = Math.max(pick, notPick);
    }
}