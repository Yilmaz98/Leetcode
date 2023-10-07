class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        int i = 0;
        
        while(i + 2 < n) {
            if(nums[i] != nums[i + 2]) {
              nums[ptr++] = nums[i];
            }
            i++;
        }
        
        while(i< n) {
            nums[ptr++] = nums[i];    
            i++;
        }
    
        return ptr;
    }
}