class Solution {
    public int removeElement(int[] nums, int val) {
       int n = nums.length;
       int i = 0;
        int ptr = 0;
        
        while(i < n) {
            if(nums[i] != val) {
                nums[ptr++] = nums[i];
            }
            i++;
        }
        
        return ptr;
    }
}