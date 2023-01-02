class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        int lowerCount = 0;
        
        for(int i=0;i<word.length();i++) {
            if(Character.isLowerCase(word.charAt(i))) {
               lowerCount++;
            }
            else if(Character.isUpperCase(word.charAt(i))) {
               upperCount++;
            }
        }
        
        if(lowerCount == word.length() || upperCount == word.length())
            return true;
        
        for(int i=1;i<word.length();i++) {
            if(Character.isUpperCase(word.charAt(i)))
                return false;
        }
        
        return Character.isUpperCase(word.charAt(0));
     }
}