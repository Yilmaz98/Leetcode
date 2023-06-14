class SparseVector {
    
    int[] arr;
    SparseVector(int[] nums) {
        int n = nums.length;
        arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = nums[i];
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        for(int i=0;i<arr.length;i++) {
            result += arr[i] * vec.arr[i];
        }
        
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);