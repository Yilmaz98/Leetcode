class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        if(nums.length == 1)
            return true;
        for(int i=0;i<nums.length-1;i++) {
            if(i > maxJump)
                return false;
            int jump = i + nums[i];
            maxJump = Math.max(jump, maxJump);
            if(maxJump >= nums.length-1)
                return true;
        }
        
        return false;
    }
}