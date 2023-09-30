class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        // Remove ending ) paranthesis
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                open++;
                balance++; 
            } else if(s.charAt(i) == ')') {
                if(balance == 0)
                    continue;
                balance--;
            }
            sb.append(s.charAt(i));
        }
        

        
        // Remove starting paranthesis which are unnecessary
        int openToKeep = open - balance;
        StringBuilder sb2 = new StringBuilder();
        for(int i=0;i<sb.length();i++) {
            if(sb.charAt(i) == '(') {
                if(openToKeep == 0) {
                    continue;
                }
                openToKeep--;
            }
            sb2.append(sb.charAt(i));
        }
        
        return sb2.toString();        
    }
}