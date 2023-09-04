class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        if(m > n) {
             return isOneEditDistance(t,s);
        }
           
        
        if(n - m > 1)
            return false;
        
        boolean oneDiff = (n - m == 1) ? true: false;
        
        
        for(int i=0;i<m;i++) {
            if(s.charAt(i) != t.charAt(i)) {
                if(oneDiff) {                    
                    return s.substring(i).equals(t.substring(i+1));
                } else {
                    return s.substring(i+1).equals(t.substring(i+1));
                }
            }
        }
        
        return !s.equals(t);
    }
}