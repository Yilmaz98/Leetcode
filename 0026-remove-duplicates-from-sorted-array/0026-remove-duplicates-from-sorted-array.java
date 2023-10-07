class Solution {
    public int removeDuplicates(int[] nums) {
        int ptr = 0;
        int i = 0;
        while(i + 1 < nums.length) {
            if(nums[i] != nums[i+1]) {
                nums[ptr++] = nums[i];
            }
               i++;
        }
        nums[ptr++] = nums[i];
        
        return ptr;
    }
}