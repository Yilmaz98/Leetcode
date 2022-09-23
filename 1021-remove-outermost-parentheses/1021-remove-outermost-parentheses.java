class Solution {
    public String removeOuterParentheses(String s) {
         StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')  {
                if(opened > 0)
                    sb.append(c); 
                opened++;
            }
                
            if (c == ')') {
                if(opened > 1)
                    sb.append(c);
                opened--;
            }
        }
        return sb.toString();
    }
}