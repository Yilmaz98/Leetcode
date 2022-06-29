class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> m = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i),0) + 1);
        }
        List<Integer> l = new ArrayList<>();
        for(Character c: m.keySet()) {
            l.add(m.get(c));
        }
        Collections.sort(l, Collections.reverseOrder());
        
        int minDecrements = 0;
        
        for(int i=1;i<l.size();i++) {
            Integer a = l.get(i);
            Integer b = l.get(i-1);
            if(a.equals(b)){
                l.set(i,l.get(i) - 1);
                minDecrements++;
            }
            else if(l.get(i-1) < l.get(i)) {
                if(l.get(i-1) == 0) {
                   minDecrements += l.get(i);
                   l.set(i, l.get(i-1));   
                } else {
                    minDecrements += l.get(i) - l.get(i-1) + 1;
                    l.set(i, l.get(i-1) - 1);  
                }
            }
        }
        return minDecrements;
    }
}