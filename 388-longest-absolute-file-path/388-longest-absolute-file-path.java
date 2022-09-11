class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        
        String[] curr = input.split("\n");
        int result = 0;
        
        for(String s: curr) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.length() - level;
            
            while(st.size() > level + 1) {
                st.pop();
            } 
            if(s.contains(".")) 
                result = Math.max(result, st.peek() + len);
             else 
                st.push(st.peek() + len + 1);
        }
        
        return result;
    }
}