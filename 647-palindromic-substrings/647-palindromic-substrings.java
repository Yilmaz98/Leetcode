class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length()-1;i++) {
            extendPalindrome(s,i,i);
            extendPalindrome(s,i,i+1);
        }
        return count+1;
    }
    
    public void extendPalindrome(String s, int j, int k) {
        while(j>=0 && k<s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
            count++;
        }
    }
}