class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        while (low < high) {
             System.out.println("Low:" + low);
             System.out.println("High:" + high);
            int mid = low + (high - low) / 2;
            System.out.println("Mid:" + mid);
            if (arr[mid] - (mid + 1) >= k) 
                high = mid;  
            else 
                low = mid + 1;
        }
        return low + k;
    }
}