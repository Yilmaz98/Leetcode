class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        
        Map<Integer,Integer> m = new HashMap<>();
        
        for(int i=0;i<nums2.length;i++) {
            for(int j=i+1;j<nums2.length;j++) {
                if(nums2[j] > nums2[i]) {
                    m.put(nums2[i],nums2[j]);
                    break;
                }
            }
        }
        
        for(int i=0;i<nums1.length;i++) {
            result[i] = m.containsKey(nums1[i]) ? m.get(nums1[i]) : -1;
        }
        
        return result;
    }
}