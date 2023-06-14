class SparseVector {
    Map<Integer, Integer > m;
    SparseVector(int[] nums) {
        m = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            if(0 != nums[i]) {
                m.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int result = 0;
        
        for(Integer i: m.keySet()) {
            if(vec.m.containsKey(i)) {
                result += m.get(i) * vec.m.get(i);
            }
        }
        
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);