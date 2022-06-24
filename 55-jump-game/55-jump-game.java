class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        if(nums.length == 1)
            return true;
        for(int i=0;i<nums.length-1;i++) {
            if(i > maxJump)
                return false;
            maxJump = Math.max(i + nums[i], maxJump);
            if(maxJump >= nums.length-1)
                return true;
        }
        
        return false;
    }
}