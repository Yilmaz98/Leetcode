class Solution {
    public int findKthLargest(int[] nums, int k) {
        int K = nums.length - k;
        int ans = quickselect(nums, K, 0, nums.length-1);
        return ans;
    }
    
    public int quickselect(int[] nums, int k,  int l, int r) {
        int pivot = nums[r];
        int p = l;
        
        for(int i=l;i<r;i++) {
            if(nums[i] <= pivot) {
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
                p++;
            }
        }
        int temp = nums[p];
        nums[p] = nums[r];
        nums[r] = temp;
        
        if(p == k){
            return nums[p];
        }
        else if(p<k) {
            return quickselect(nums,k,p+1,r);
        }
        else 
        {
              return quickselect(nums, k, l, p-1);
        }
    }
}