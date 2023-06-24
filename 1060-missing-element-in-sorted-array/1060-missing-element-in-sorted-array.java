class Solution {
    public int missingElement(int[] nums, int k) {
        
        
        for(int i=0;i<nums.length -1;i++) {
            int remainingNums = nums[i+1] - nums[i] -1;
            if(remainingNums >= k) {
                return nums[i] + k;
            } 
            if(remainingNums > 0)
                k-=remainingNums;
        }
        
        return nums[nums.length -1] + k;
    }
}