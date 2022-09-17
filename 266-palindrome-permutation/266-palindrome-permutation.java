class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        
        for(int i=0;i<s.length();i++) {
            count[s.charAt(i)-'a']++;
        }
        
        int onesCount = 0;
        for(int i=0;i<26;i++) {
            if(count[i]%2!=0) {
                onesCount++;
            }
            
            if(onesCount>1)
                return false;
        }
        
        
        
        return true;
    }
}