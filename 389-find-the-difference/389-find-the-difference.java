class Solution {
    public char findTheDifference(String s, String t) {
        Map<Character,Integer> m = new HashMap<>();
        
        for(Character c : s.toCharArray()) {
            m.put(c, m.getOrDefault(c,0)+1);
        }
        
        for(Character c : t.toCharArray()) {
           if(m.containsKey(c)) {
               m.put(c, m.getOrDefault(c,0)-1);
               if(m.get(c) == 0)
                   m.remove(c);
           } else {
               m.put(c,m.getOrDefault(c,0)+1);
           }
        }
        
        
        return m.keySet().iterator().next();
    }
}