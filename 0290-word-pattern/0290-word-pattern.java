class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(words.length != pattern.length())
            return false;
        
        Map<Character, String> m1 = new HashMap<>();
        Map<String, Character> m2 = new HashMap<>();
        
        for(int i=0;i<pattern.length();i++) {
            if(!m1.containsKey(pattern.charAt(i)) && !m2.containsKey(words[i])) {
                m1.put(pattern.charAt(i), words[i]);
                m2.put(words[i], pattern.charAt(i));
            } else {
                if(!m1.containsKey(pattern.charAt(i)) || !m2.containsKey(words[i]) || !m1.get(pattern.charAt(i)).equals(words[i]) || !m2.get(words[i]).equals(pattern.charAt(i))) {
                    return false;
                } 
            }
        }
        
        return true;
    }
}