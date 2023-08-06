class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        }

        // Read pointers for nums1Copy and nums2 respectively.
        int p1 = 0;
        int p2 = 0;
        int p = 0;
                
        // Compare elements from nums1Copy and nums2 and write the smallest to nums1.
            while(p1<m && p2<n) {
                  if (nums1Copy[p1] < nums2[p2]) 
                    nums1[p++] = nums1Copy[p1++];
                  else
                    nums1[p++] = nums2[p2++];
            }
        
        while(p1 < m) {
            nums1[p++] = nums1Copy[p1++];
        }
        
        while(p2 < n) {
            nums1[p++] = nums2[p2++];
        }
          
    }
}