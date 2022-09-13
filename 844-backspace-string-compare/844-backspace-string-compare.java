class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> t1 = new Stack<>();
        
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '#') {
                if(!s1.isEmpty())
                    s1.pop();
            } 
            else
                s1.push(s.charAt(i));
        }
        
        for(int i=0;i<t.length();i++) {
            if(t.charAt(i) == '#') {
                 if(!t1.isEmpty())
                     t1.pop();
            }         
            else
                t1.push(t.charAt(i));
        }
        
        if(s1.size() != t1.size())
            return false;
        
        while(!s1.isEmpty()) {
            if(s1.pop() != t1.pop())
                return false;
        }
        
        return true;
    }
}