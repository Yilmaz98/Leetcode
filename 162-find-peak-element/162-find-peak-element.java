class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            
            int mid = left + (right - left) / 2;
            int next = mid + 1;
            if(nums[next] > nums[mid]) {
                left = next;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
}