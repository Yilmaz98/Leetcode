class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charToString = new HashMap<>();
        Map<String, Character> stringToChar = new HashMap<>();
        
        String[] string2 = s.split(" ");
        
        if(string2.length != pattern.length())
            return false;
        
        int idx = 0;
        for(Character p : pattern.toCharArray()) {
            String word = string2[idx];
            
            if(charToString.containsKey(p) && !charToString.get(p).equals(word) || stringToChar.containsKey(word) && stringToChar.get(word) != p)
                return false;
            
            charToString.put(p, word);
            stringToChar.put(word, p);
            idx++;
        }
        
        return true;
    }
}