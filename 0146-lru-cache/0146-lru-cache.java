class LRUCache {
    LinkedHashMap<Integer, Integer> m;
    private int SIZE;
    
    public LRUCache(int capacity) {
        m = new LinkedHashMap<>();
        SIZE = capacity;
    }
    
    public int get(int key) {
        if(m.containsKey(key)) {
            int value = m.get(key);
            m.remove(key);
            m.put(key, value);
            
            return value;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(m.containsKey(key)) {
            m.remove(key);
        } else if(m.size() + 1 > SIZE) {
            m.remove(m.keySet().iterator().next());
        }
        m.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */