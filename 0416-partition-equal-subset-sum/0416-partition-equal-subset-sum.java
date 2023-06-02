class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        for(int num : nums)
            sum += num;
        
        if(sum %2 != 0)
            return false;
        
        int[][] memo = new int[n+1][sum+1];
        
        return helper(memo,0,sum/2, nums) == 1? true: false;
    }
    
    
    public int helper(int[][] memo, int i, int target, int[] nums) {
        if(i == nums.length) {
            if(target == 0)
                return 1;
            else
                return 2;
        }
        
        if(target == 0)
            return 1;
        
        if(target < 0)
            return 2;
        
        if(memo[i][target] != 0)
            return memo[i][target];
        
        int include = helper(memo, i+1, target - nums[i],nums);
        int exclude = helper(memo,i+1,target,nums);
        
        int result = include==1? 1:exclude==1?1: 2;
        
        return memo[i][target] = result;
    }
}