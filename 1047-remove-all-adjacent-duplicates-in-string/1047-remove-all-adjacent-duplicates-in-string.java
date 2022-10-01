class Solution {
    public String removeDuplicates(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        
        for(int i=0;i<sb.length();i++) {
            if(i==0 || sb.charAt(i) != sb.charAt(i-1)) {
                st.push(1);
            } else {
                int counts = st.pop() + 1;
                if(counts != 2) {
                    st.push(counts);
                } else {
                    sb.delete(i-1,i+1);
                    i = i-2;
                }
            }
        }
        
        return sb.toString();
    }
}