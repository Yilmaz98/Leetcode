class Solution {
    public boolean arrayContains(int target, int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == target) {
                return true;
            }
        }
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(arrayContains(target,matrix[mid])) {
                return true;
            } else if(matrix[mid][0] > target) {
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}