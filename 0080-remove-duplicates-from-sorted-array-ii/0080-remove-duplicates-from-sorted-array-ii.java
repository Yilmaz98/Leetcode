class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int count = 1;
        int ptr = 0;
        int i = 0;
        
        while(i + 1 < n) {
            if(nums[i] != nums[i + 1]) {
                if(count >=2) {
                    nums[ptr++] = nums[i];
                    nums[ptr++] = nums[i];
                } else {
                    nums[ptr++] = nums[i];
                }
                count = 0;
            }
            count++;
            i++;
        }
        
         if(count >=2) {
            nums[ptr++] = nums[i];
            nums[ptr++] = nums[i];
        } else {
            nums[ptr++] = nums[i];
        }
        
        return ptr;
    }
}