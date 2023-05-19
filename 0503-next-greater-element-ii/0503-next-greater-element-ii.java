class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res,-1);
        for(int i=0;i<2 * nums.length;i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i%nums.length])
                res[st.pop()] = nums[i%nums.length];
            st.add(i%nums.length);
        }
        
        return res;
    }
}