public class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
};

class LRUCache {
    Map<Integer, ListNode> dic;
    ListNode head;
    ListNode tail;
    int capacity;
    
    public LRUCache(int capacity) {
        dic = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public void addToList(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }
    
    public void removeFromList(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public int get(int key) {
        if(!dic.containsKey(key))
            return -1;
        
        ListNode curr = dic.get(key);
        removeFromList(curr);
        addToList(curr);
        
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(dic.containsKey(key)) {
            ListNode nodeToRemove = dic.get(key);
            removeFromList(nodeToRemove);
        }
        
        ListNode curr = new ListNode(key, value);
        dic.put(key, curr);
        addToList(curr);
        
        if(dic.size() > capacity) {
            dic.remove(head.next.key);
            removeFromList(head.next);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */