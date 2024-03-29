class LRUCache {
    Map<Integer, ListNode> dict;
    ListNode head;
    ListNode tail;
    int capacity;
    
    public LRUCache(int capacity) {
        dict = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }
    
    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public void add(ListNode node) {
        ListNode prevEnd = tail.prev;
        prevEnd.next = node;
        node.next = tail;
        node.prev = prevEnd;
        tail.prev = node;
    }
    
    public int get(int key) {
        if(!dict.containsKey(key))
            return -1;
        
        ListNode node = dict.get(key);
         remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(dict.containsKey(key)) {
            ListNode oldNode = dict.get(key);
            remove(oldNode);
        }
        
        ListNode newNode = new ListNode(key,value);
        dict.put(key, newNode);
        add(newNode);
        
        if(dict.size() > capacity) {
            ListNode firstNode = head.next;
            remove(firstNode);
            dict.remove(firstNode.key);
        }
    }
    
    class ListNode {
        int key;
        int val;
        ListNode next;
        ListNode prev;
        
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
        
        int getValue() {
            return this.val;
        }
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */