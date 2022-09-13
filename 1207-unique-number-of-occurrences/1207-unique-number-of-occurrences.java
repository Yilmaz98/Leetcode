class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<arr.length;i++) {
            m.put(arr[i], m.getOrDefault(arr[i],0)+1);
        }
        
        Set<Integer> s = new HashSet<>();
        
        for(Integer i : m.keySet()) {
            s.add(m.get(i));
        }
        
        return s.size() == m.size();
    }
}