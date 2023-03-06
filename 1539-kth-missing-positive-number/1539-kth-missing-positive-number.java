class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            if(arr[mid] - 1 - mid >= k)
                high = mid;
            else
                low = mid + 1;
        }
        
        return low + k;
    }
}