class Solution {
    class SpecialNode {
        String name;
        int freq;
        
        SpecialNode(String name, int freq) {
            this.name = name;
            this.freq= freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
       Map<String, Integer> m = new HashMap<>();
        
        for(String word : words) {
            m.put(word, m.getOrDefault(word,0) + 1);
        }
        
        PriorityQueue<SpecialNode> pq = new PriorityQueue<>((a,b) -> a.freq == b.freq ? a.name.compareTo(b.name) : b.freq - a.freq);
        
        for(String key : m.keySet()) {
            pq.add(new SpecialNode(key,m.get(key)));
        }
        
        List<String> result = new ArrayList<>();
        
        while(k-->0) {
            result.add(pq.poll().name);
        }
        
        return result;
    }
}