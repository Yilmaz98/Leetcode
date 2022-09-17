class Solution {
    public boolean checkIfPangram(String sentence) {
        if(sentence.length() < 26)
            return false;
            
        int[] count = new int[26];
        
        
        for(int i=0;i<sentence.length();i++) {
            count[sentence.charAt(i) - 'a']++;
        }
        
        for(int i=0;i<26;i++) {
            if(count[i] == 0)
                return false;
        }
        
        return true;
    }
}