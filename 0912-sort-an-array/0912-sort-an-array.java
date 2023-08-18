class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public void mergeSort(int[] nums, int low, int high) {
        if(low < high) {
            int mid = low + (high - low) /2;
            
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }
    
    public void merge(int[] nums, int low, int mid, int high) {
        
        int[] left = new int[mid - low +1];
        int[] right = new int[high - mid];
        
            
        for(int i=0;i<left.length;i++) {
            left[i] = nums[low + i];
        }
            
        for(int i=0;i<right.length;i++) {
            right[i] = nums[mid + i + 1];
        }
        
                int i = 0;
        int j = 0;
        int m = left.length;
        int n = right.length;
        int idx = low;
        
        while(i < m && j < n) {
            if(left[i] <= right[j]) {
                nums[idx++] = left[i++];
            } else {
                nums[idx++] = right[j++];
            }
        }
        
        while(i < m) {
            nums[idx++] = left[i++];
        }
        
        while(j < n) {
            nums[idx++] = right[j++];
        }
    }
}