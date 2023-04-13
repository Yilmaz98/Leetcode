class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        
        int idx = 0;
        for(int i=0;i<pushed.length;i++) {
            st.push(pushed[i]);
            while(!st.isEmpty() && st.peek() == popped[idx]) {
                st.pop();
                idx++;
            } 
        }
         
        while(idx < popped.length) {
            if(st.pop() != popped[idx]) {
                return false;
            } 
            idx++;
        }
            
        
        return true;
    }
}