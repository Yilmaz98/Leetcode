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
        if(idxList.size() < vec.idxList.size())
            return dotProd(this,vec);
        else 
            return dotProd(vec, this);
    }
    
    public int dotProd(SparseVector a, SparseVector b) {
        int result = 0;
        for(int i=0;i<a.idxList.size();i++) {
            int[] curr = a.idxList.get(i);
            
            int[] even = binarySearch(curr[0], b.idxList);
            
            if(curr[0] == even[0]) {
                result += curr[1] * even[1];
            } 
        }
        
        return result;
    }
    
    public int[] binarySearch(int idx, List<int[]> searchList) {
        int low = 0;
        int high = searchList.size() -1;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            if(searchList.get(mid)[0] < idx) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return searchList.get(low);
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);