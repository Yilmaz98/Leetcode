class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4) {
            return 0;
        }
        
        int res = Integer.MAX_VALUE;
        
        Arrays.sort(nums);
        
        int n = nums.length;
        
        for(int i=0;i<4;i++) {
            res = Math.min(res, nums[n-4+i] - nums[i]);    
        }
        
        return res;
    }
}