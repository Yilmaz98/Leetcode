class Solution {
    public boolean isAlphaNumeric(String s, int i) {
         if((s.charAt(i) >='a' && s.charAt(i) <='z') || (s.charAt(i) >='A'  && s.charAt(i) <='Z') || (s.charAt(i) >='0'  && s.charAt(i) <='9')) {
             return true;
         }
        return false;
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i<j) {
            while(!isAlphaNumeric(s,i) && i<j){
                i++;
            } 
            
            while(!isAlphaNumeric(s,j) && j>i) {
                j--;
            }
            
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
            
            i++;
            j--;
           
        }
        return true;
    }
}