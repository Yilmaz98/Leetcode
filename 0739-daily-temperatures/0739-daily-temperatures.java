class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        
        for(int i=0;i<temperatures.length;i++) {
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int prev = st.pop();
                ans[prev] = i - prev; 
            }
            st.push(i);
        }
        
        return ans;
    }
}