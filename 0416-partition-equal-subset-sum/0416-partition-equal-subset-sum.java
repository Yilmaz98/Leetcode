class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
        } 
        
        if(sum % 2 != 0)
            return false;
        
        int n = nums.length;
        
        int[][] dp = new int[n][sum * 2 + 1];
        
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return recurse(nums, 0, sum/2, dp, sum) != 0? true : false;
    }
    
    public int recurse(int[] nums, int start, int target, int[][] dp, int sum) {
        if(start == nums.length - 1) {
            
            if(nums[start] == target) {
                return 1;
            }
            return 0;
        }
        
        if(dp[start][sum + target] != -1)
            return dp[start][sum + target];
        
        int pick = 0;
        int notPick = 0;
        
        pick = recurse(nums, start + 1, target - nums[start],dp, sum);
        notPick = recurse(nums, start + 1, target, dp, sum);
        
        return dp[start][sum + target] = pick + notPick;
    }
}