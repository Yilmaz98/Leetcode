class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int[] arr = new int[nums1.length + nums2.length];
        
        int i=0, j=0;
        int in=0;
        
        for (; i<nums1.length && j< nums2.length;){
            if (nums1[i] < nums2[j]) {
            	arr[in++] = nums1[i];
            	i++;
            } else {
            	arr[in++] = nums2[j];
            	j++;
            }
        }
        
        while (i < nums1.length) {
        	arr[in++] = nums1[i];
        	i++;
        }

        while (j < nums2.length) {
        	arr[in++] = nums2[j];
        	j++;
        }
        if (arr.length % 2 != 0) return arr[arr.length/2];
        
        return Double.valueOf(arr[arr.length/2] + arr[(arr.length/2)-1])/2;
    }
}