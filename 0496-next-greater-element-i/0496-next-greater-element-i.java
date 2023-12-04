class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<nums2.length;i++) {
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                int last = st.pop();
                m.put(nums2[last], nums2[i]);
            }
            
            st.push(i);
        }
        
        for(int i=0;i<nums1.length;i++) {
            if(!m.containsKey(nums1[i]))
                nums1[i] = -1;
            else 
                nums1[i] = m.get(nums1[i]);
        }
        
        return nums1;
    }
}