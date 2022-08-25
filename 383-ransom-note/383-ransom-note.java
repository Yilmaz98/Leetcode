class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> m1 = new HashMap<>();
        Map<Character,Integer> m2 = new HashMap<>();
        
        for(int i=0;i<ransomNote.length();i++) {
            m1.put(ransomNote.charAt(i),m1.getOrDefault(ransomNote.charAt(i), 0)+1);
        }
        
        for(int i=0;i<magazine.length();i++) {
            m2.put(magazine.charAt(i),m2.getOrDefault(magazine.charAt(i),0)+1);
        } 
        
        for(Character a: m1.keySet()) {
            if(!m2.containsKey(a) ||  m2.get(a) < m1.get(a)) {
                return false;
            }
        }
        
        return true;
    }
}