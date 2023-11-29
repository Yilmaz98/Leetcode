class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return recurse(nums, target, 0);
    }
    
    public int recurse(int[] nums, int target, int start) {
        if(start == nums.length - 1) {
            int temp = 0 + nums[start];
            int temp2 = 0 - nums[start];
            
            if(target - temp == 0 && target - temp2 == 0)
                return 2;
            
            if(target - temp == 0 || target - temp2 == 0)
                return 1;
            
            return 0;
        }
        
        
        int plus = 0;
        int minus = 0;
        
        int temp = 0 + nums[start];
        plus = recurse(nums, target - temp, start + 1);
            
        int temp2 = 0 - nums[start];
        minus = recurse(nums, target - temp2, start + 1);
        
        return plus + minus;
    }
}