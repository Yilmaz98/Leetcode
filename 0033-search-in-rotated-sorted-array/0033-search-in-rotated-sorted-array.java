class Solution {
    public int search(int[] nums, int target) {
        int result = 0;
        int n = nums.length;
        
        if(nums[0] == target) return 0;
        
        if(nums[n - 1] == target) return n - 1;
        
        int low = 1;
        int high = n - 2;
           
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target)
                return mid;
            
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return -1;
    }
}