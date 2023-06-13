class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int idx = -1;
        
        if(nums.length == 1) {
            if(nums[0] == target)
                return new int[]{0,0};
        }
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
            
            if(nums[mid] == target) idx = mid;
        }
        
        int[] result = new int[2];
        result[0] = idx;
        
        low = 0;
        high = nums.length - 1;
        idx = -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid-1;
            }
            
            if(nums[mid] == target) idx = mid;
        }
        
        result[1] = idx;
        
        return result;
    }
}