class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recurse(nums, target, 0);
    }
    
    public int recurse(int[] nums, int target, int idx) {
        if(idx == nums.length) {
            if(target == 0)
                return 1;
            
            return 0;
        }
        
        int pos = 0;
        int neg = 0;
        
        pos = recurse(nums, target - nums[idx], idx+1);
        neg = recurse(nums, target + nums[idx], idx+1);
        
        return pos + neg;
    }
}