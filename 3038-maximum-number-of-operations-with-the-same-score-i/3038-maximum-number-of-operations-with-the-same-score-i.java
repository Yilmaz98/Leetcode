class Solution {
    public int maxOperations(int[] nums) {
        if(nums.length <=1)
            return 0;
        
        int score = nums[0] + nums[1];
        int count = 0;
        
        for(int i =0;i<nums.length - 1;i+=2) {
            if(nums[i] + nums[i+1] == score)
                count++; 
            else
                break;
        }
        
        return count;
    }
}