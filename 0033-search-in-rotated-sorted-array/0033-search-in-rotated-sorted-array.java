class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        
        int low = 0;
        int high = n - 1;
        int ans = -1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid]) {
                    if(nums[mid] == target) {
                        ans = mid;
                    }
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if(nums[mid] <= target && target <= nums[high]) {
                    if(nums[mid] == target) {
                        ans = mid;
                    }
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        
        return ans;
    }
}