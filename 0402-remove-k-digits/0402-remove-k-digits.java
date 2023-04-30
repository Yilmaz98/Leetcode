class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<num.length();i++) {
            while(k>0 && (!st.isEmpty() && st.peek() > num.charAt(i))) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        
        while(k>0) {
            st.pop();
            k--; 
        }
        
        
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        sb.reverse();
                
        for(int i=0;i<sb.length();i++) {
            if(sb.charAt(i) != '0')
                break;
            sb = sb.deleteCharAt(i);
            i--;
        }
        
        if(sb.length() == 1)
            return sb.toString();
        
        if(sb.length() == 0)
            return "0";
        
        return sb.toString();
    }
}