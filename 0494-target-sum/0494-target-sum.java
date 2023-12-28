class Solution {
    int total = 0;
    public int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2 * total + 1];
        for(int i=0;i<nums.length;i++)
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        return recurse(nums, target, 0, dp, 0);
    }
    
    public int recurse(int[] nums, int target, int idx, int[][] dp, int sum) {
        if(idx == nums.length) {
            if(target == sum)
                return 1;
            
            return 0;
        }
                
        if(dp[idx][sum + total] != Integer.MIN_VALUE)
            return dp[idx][sum + total];
        
        int pos = 0;
        int neg = 0;
        
        pos = recurse(nums, target, idx+1, dp, sum + nums[idx]);
        neg = recurse(nums, target, idx+1, dp, sum - nums[idx]);
        
        return dp[idx][sum + total] = pos + neg;
    }
}