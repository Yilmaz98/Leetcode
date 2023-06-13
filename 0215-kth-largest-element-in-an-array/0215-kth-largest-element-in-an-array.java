class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickselect(nums, k, 0, nums.length - 1);
    }
    
    public void printNums(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    public int quickselect(int[] nums, int k, int l , int r) {
        int pivot = nums[r], p = l;
        for(int i=l;i<r;i++) {
            if(nums[i] <= pivot) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;
        
        if(k == p) {
            return nums[p];
        } else if(k < p) {
            return quickselect(nums,k,l,p-1);
        } else {
            return quickselect(nums,k,p+1,r);
        }
    }
}