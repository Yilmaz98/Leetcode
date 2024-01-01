class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<String, Character> stringToChar = new HashMap<>();
        Map<Character, String> charToString = new HashMap<>();
        
        return recurse(pattern, s, 0, 0, stringToChar, charToString);
    }
    
    public boolean recurse(String pattern, String s, int p, int idx, Map<String, Character> stringToChar, Map<Character, String> charToString) {
        if(p == pattern.length() && idx == s.length())
            return true;
        
        if(p == pattern.length() || idx == s.length())
            return false;
        
        char ch = pattern.charAt(p);
        
        for(int i = idx;i<s.length();i++) {
            String tentativeString = s.substring(idx, i + 1);
            
            if(stringToChar.containsKey(tentativeString) && stringToChar.get(tentativeString).equals(ch) && charToString.containsKey(ch) && charToString.get(ch).equals(tentativeString)) {
                if(recurse(pattern, s, p + 1, i + 1, stringToChar, charToString))
                    return true;
            } 
            else if(!charToString.containsKey(ch)) {
                if(!stringToChar.containsKey(tentativeString)) {
                    charToString.put(ch, tentativeString);
                    stringToChar.put(tentativeString, ch);
                    
                    if(recurse(pattern, s, p + 1, i + 1, stringToChar, charToString))
                        return true;
                    
                    charToString.remove(ch);
                    stringToChar.remove(tentativeString);
                }
            }
        }
        
        return false;
    }
}