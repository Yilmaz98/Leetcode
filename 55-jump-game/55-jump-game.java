class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1)
            return true;
        
        int maxJump = 0;
        for(int i=0;i<nums.length;i++) {
            if(i != nums.length-1 &&  i >=  maxJump + nums[i]) {
                return false;
            }
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        
        return true;
    }
}