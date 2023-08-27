class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
          if (s1.length() > s2.length())
            return false;
        Map<Character, Integer> m1 = new HashMap<>();
        
        for(char c : s1.toCharArray()) {
            m1.put(c, m1.getOrDefault(c,0) + 1);
        }
        
        for(int i = 0;i <= s2.length() - s1.length();i++) {
            Map<Character, Integer> m2 = new HashMap<>();
            for(int j=0;j<s1.length();j++) {
                 m2.put(s2.charAt(i+j), m2.getOrDefault(s2.charAt(i+j),0) + 1);
            }
            if(matches(m1,m2)) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean matches(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        for(Character c : m1.keySet()) {
            if(m1.get(c) - m2.getOrDefault(c,-1) != 0)
                return false;
        }
        
        return true;
    }
}