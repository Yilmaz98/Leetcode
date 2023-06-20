class Solution {
    public boolean compare(String word1, String word2, Map<Character, Integer> m) {
        int i = 0;
        int j = 0;
                
        while(i < word1.length() && j < word2.length()) {   
            if(m.get(word1.charAt(i)) > m.get(word2.charAt(i)))
                return false;
            else if(m.get(word1.charAt(i)) < m.get(word2.charAt(i)))
                return true;
            i++;
            j++;
        }
        
        if(i < word1.length())
            return false;
        
        return true;
    }
    
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> m = new HashMap<>();
        
        for(int i=0;i<order.length();i++) {
            m.put(order.charAt(i), i);
        }
        
        
        for(int i=0;i<words.length;i++) {
            for(int j=i+1;j<words.length;j++) {
                String word1 = words[i];
                String word2 = words[j];
                
                if(!compare(word1, word2, m)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}