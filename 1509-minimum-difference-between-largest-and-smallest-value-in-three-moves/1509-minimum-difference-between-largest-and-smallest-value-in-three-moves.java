class Solution {
    public int minDifference(int[] nums) {
        if(nums.length <= 4)
            return 0;
        
        int n = nums.length;
        
        Arrays.sort(nums);
        
        int result = Integer.MAX_VALUE;
        for(int i=0;i<4;i++)
          result = Math.min(result, nums[n-4+i] - nums[i]);
        
        return result;
    }
}