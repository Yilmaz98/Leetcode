/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        
        int m = dims.get(0);
        int n = dims.get(1);
        
        int low = 0;
        int high = n;
        
        while(low < high) {
            int mid = low + (high - low)/2;
            
            for(int j=0;j<m;j++) {
                if(binaryMatrix.get(j,mid)  == 1) {
                    high = mid;
                } 
            }
            if(high != mid)
                low = mid + 1;
        }
        
        return low >=n ? -1 : low;
    }
}