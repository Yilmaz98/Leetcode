class Solution {
    public int missingNumber(int[] nums) {
        int l = nums.length;
        
        for(int i=0;i<nums.length;i++) {
            l ^= i;
            l ^= nums[i];
        }
        
        return l;
    }
}