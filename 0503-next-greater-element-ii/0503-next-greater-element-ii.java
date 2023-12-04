class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        
        int[] newNums = new int[n + n];
        
        for(int i=0;i<n;i++) {
            newNums[i] = nums[i];
            newNums[i+n] = nums[i];
        }
        
        Stack<Integer> st = new Stack<>();
        
        int[] result = new int[n];
        Arrays.fill(result , -1);
        int idx = 0;
        
        for(int i=0;i<2*n;i++) {
            while(!st.isEmpty() && newNums[st.peek()] < newNums[i]) {
                int last = st.pop();
                result[last % n] = newNums[i];
            }
            
            st.push(i);
        }
        
        return result;
    }
}