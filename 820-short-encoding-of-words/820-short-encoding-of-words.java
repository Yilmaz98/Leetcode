class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        
        for(int i=0;i<words.length;i++) {
            set1.add(words[i]);
            set2.add(words[i]);
        }
        
        for(String word1: set1) {
            for(int j=0;j<word1.length();j++) {
                String curr = word1.substring(j+1);
                
                if(set2.contains(curr)) {
                    set2.remove(curr);
                }
            }
        }
        
        int ans = 0;
        
        
        for(String word2: set2) {
            ans += word2.length();    
        }
        
        return ans + set2.size();
    }
}