class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == ']')
            {
                 if(!st.isEmpty() && st.peek() == '[') {
                     st.pop();
                     continue;
                 } 
            } 
            
            st.push(s.charAt(i));
        }
        
        int val = st.size()/2;
        return (val+1)/2;
    }
}