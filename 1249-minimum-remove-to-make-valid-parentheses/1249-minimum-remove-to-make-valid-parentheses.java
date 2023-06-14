class Solution {
    public String minRemoveToMakeValid(String s) {
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        int open = 0;
        
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
        
        int opentoKeep = open - balance;
        StringBuilder result = new StringBuilder();
        
        for(int i=0;i<sb.length();i++) {
            if(sb.charAt(i) == '(') {
                opentoKeep--;
                if(opentoKeep < 0)
                    continue;
            }
            
            result.append(sb.charAt(i));
        }
        
        return result.toString();
    }
}