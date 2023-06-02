class Solution {
    public int combinationSum4(int[] nums, int target) {
        Integer[] memo = new Integer[target+1];
        
        return helper(memo, nums, target);
    
    }
    
    public int helper(Integer[] memo, int[] nums, int sum) {
        if(sum == 0) {
             return 1;
        }

        
        if(sum < 0)
            return 0;
        
        if(memo[sum] !=null) {
            return  memo[sum];
        }
        
        int ways = 0;
        for(int j=0;j<nums.length;j++) {
                ways += helper(memo,nums,sum - nums[j]);
        }
        
        memo[sum] = ways;
        
        return memo[sum];
    }
}