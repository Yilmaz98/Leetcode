class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> s = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        
        for(int i=0;i<nums1.length;i++) {
            s.add(nums1[i]);
        }
        
        for(int i=0;i<nums2.length;i++) {
            if(s.contains(nums2[i])) {
                s2.add(nums2[i]);
            }
        }
        
        int ans[] = new int[s2.size()];
        int idx = 0;
        
        for(Integer i: s2){
            ans[idx++] = i;
        }
        
        return ans;
    }
}