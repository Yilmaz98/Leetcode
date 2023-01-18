class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int mxsum = 0;
        int maxSum = 0;
        int justSum = 0;
        int minSum = 0;
        int mnsum = 0;
        boolean pFlag = false;
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>0) {
                pFlag = true;
            }
            mxsum += nums[i];
            mnsum += nums[i];
            justSum +=nums[i];
            if(mxsum < 0) {
                mxsum = 0;
            }
            if(mnsum > 0) {
                mnsum = 0;
            }
            maxSum = Math.max(maxSum,mxsum);
            minSum = Math.min(minSum,mnsum);
        }
                
        if(!pFlag) {
            for(int i=0;i<nums.length;i++) {
                max = Math.max(max,nums[i]);
            }
            return max;
        }

      
        return Math.max(maxSum, justSum - minSum);
    }
}