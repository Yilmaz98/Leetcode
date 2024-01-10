class TrieNode {
    Map<Character, TrieNode> childrenMap;
    boolean isWord;
        
    TrieNode() {
        childrenMap = new HashMap<>();
        isWord = false;
    }
}

class Trie {
    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode ws = root;
        
        for(Character c : word.toCharArray()) {
            if(!ws.childrenMap.containsKey(c)) {
                ws.childrenMap.put(c, new TrieNode());
            }
            ws = ws.childrenMap.get(c);
        }
        ws.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode ws = root;
        
        for(Character c : word.toCharArray()) {
            if(!ws.childrenMap.containsKey(c)) {
                return false;
            }
            ws = ws.childrenMap.get(c);
        }
        return ws.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        
        for(Character c : prefix.toCharArray()) {
            if(!ws.childrenMap.containsKey(c)) {
                return false;
            }
             ws = ws.childrenMap.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */