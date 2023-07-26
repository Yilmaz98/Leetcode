class Solution {
    public String minRemoveToMakeValid(String s) {
        int openSeen = 0;
        int balance = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                openSeen++;
                balance++;
            } else if(s.charAt(i) == ')') {
                if(balance == 0)
                    continue;
                balance--;
            }
            sb.append(s.charAt(i));
        }
        
             // Pass 2: Remove the rightmost "("
        StringBuilder result = new StringBuilder();
        int openToKeep = openSeen - balance;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                openToKeep--;
                if (openToKeep < 0) continue;
            }
            result.append(c);
        }

        return result.toString();
    }
}