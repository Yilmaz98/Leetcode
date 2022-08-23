class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low<high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] <= nums[high]) {
                high = mid;
            } else {
                low = mid+1;
            }
        }
        
        int rot = low;
        low = 0;
        high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int realMid = (mid + rot) % nums.length;
            if(nums[realMid] == target) {
                return realMid;
            } else if(nums[realMid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return -1;
        
    }
}