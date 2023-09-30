class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<s.length();i++) {
            Character fin = Character.toLowerCase(s.charAt(i));
            
            if(fin >= 'a' && fin <= 'z' || fin >='0' && fin <= '9') {
                sb.append(fin);
            }
        }
        
        int i = 0;
        int j = sb.length() - 1;
        
        while(i < j) {
            if(sb.charAt(i) == sb.charAt(j)) {
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}