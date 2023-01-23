class MyHashMap {
    List<int[]>[] lists;
    int size = 13000;
    
    public MyHashMap() {
        lists = new List[size];
        
        for(int i=0;i<size;i++) {
            lists[i] = new ArrayList<>();
        }
    }
    
    public int getHashCode(int key) {
        return key % size;
    }
    
    public void put(int key, int value) {
        int idx = getHashCode(key);
        
        for(int i=0;i<lists[idx].size();i++) {
            if(lists[idx].get(i)[0] == key) {
                lists[idx].get(i)[1] = value;
                return;
            }
        }
        
        lists[idx].add(new int[]{key,value});
    }
    
    public int get(int key) {
        int idx = getHashCode(key);
        
        for(int i=0;i<lists[idx].size();i++) {
            if(lists[idx].get(i)[0] == key) {
                return lists[idx].get(i)[1];
            }
        }
        
        return -1;
    }
    
    public void remove(int key) {
        int idx = getHashCode(key);
        for(int i=0;i<lists[idx].size();i++) {
            if(lists[idx].get(i)[0] == key) {
                lists[idx].remove(i);
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */