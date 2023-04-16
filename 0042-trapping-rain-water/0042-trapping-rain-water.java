class Solution {
    public int trap(int[] height) {
        int maxIndex = 0;
        int maxHeight = Integer.MIN_VALUE;
        
        for(int i=0;i<height.length;i++) {
            if(maxHeight < height[i]) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        
        
        Stack<Integer> st = new Stack<>();
        
        int leftAns = 0;
        
        for(int i=0;i<=maxIndex;i++) {
            if(!st.isEmpty() && st.peek() >= height[i]) {
                leftAns += (st.peek() - height[i]);
                continue;
            } else if(!st.isEmpty() && st.peek() < height[i]) {
                st.pop();
            } 
            st.push(height[i]);
        }
        
        
        st.clear();
        int rightAns = 0;
        
          for(int i=height.length - 1;i>=maxIndex;i--) {
            if(!st.isEmpty() && st.peek() >= height[i]) {
                rightAns += (st.peek() - height[i]);
                continue;
            } else if(!st.isEmpty() && st.peek() < height[i]) {
                st.pop();
            } 
            st.push(height[i]);
        }
        
        return leftAns + rightAns;
        
        
        
    }
}