class SparseVector {
    List<int[]> idxList;
    
    SparseVector(int[] nums) {
        idxList = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0)
                idxList.add(new int[]{i, nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        
        int result = 0;
        int p = 0;
        int q = 0;
           
        while(p < idxList.size() && q < vec.idxList.size()) {
            if(idxList.get(p)[0] == vec.idxList.get(q)[0]) {
                result += idxList.get(p)[1] * vec.idxList.get(q)[1];
                p++;
                q++;
            } else if(idxList.get(p)[0] > vec.idxList.get(q)[0]) {
                q++;
            } else {
                p++;
            }
         }
        
        return result;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);