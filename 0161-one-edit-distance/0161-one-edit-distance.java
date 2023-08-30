class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1)
            return false;
        
        if(s.length() == t.length()) {
             int ans = 0;
            for(int i=0;i<s.length();i++) {
               if(s.charAt(i) != t.charAt(i)) {
                   ans++;
               }
            }
                        
            return ans == 1;
        }
        else {
           if(s.length() < t.length())  {
               int i = 0;
               int j = 0;
               while(i < t.length() && j < s.length()) {
                   if(s.charAt(j) != t.charAt(i)) {
                       i++;
                       continue;
                   }
                   
                   j++;
                   i++;
               }
               
               return j == s.length();
           } else {
               return isOneEditDistance(t,s);
           }
        }
    }
}