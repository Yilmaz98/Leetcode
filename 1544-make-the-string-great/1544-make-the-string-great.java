class Solution {
    
    public boolean isBad(char peeked, char curr) {
        return (Character.isLowerCase(peeked) && Character.isUpperCase(curr)) || (Character.isUpperCase(peeked) && Character.isLowerCase(curr));
    }
    
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        boolean flag = true;

        for(int i=0;i<s.length();i++) {
            if(st.isEmpty())
                    flag = true;
            while(!st.isEmpty()) {
                char peeked = st.peek();
                char curr = s.charAt(i);
                
                if((Character.toLowerCase(peeked) != Character.toLowerCase(curr)))
                {
                    flag = true;
                    break;
                }
                
                if(isBad(peeked,curr)) {
                    st.pop();
                    flag = false;
                    break;
                } else {
                    flag = true;
                    break;
                }
            }
            if(flag)
                st.push(s.charAt(i));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}