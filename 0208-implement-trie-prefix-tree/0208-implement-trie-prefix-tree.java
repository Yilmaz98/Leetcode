class Trie {
    class TrieNode {
        Map<Character, TrieNode> edges;
        boolean isWord;
        
        TrieNode() {
            this.edges = new HashMap<>();
            this.isWord = false;
        }
    }
    
    TrieNode root = new TrieNode();
    
    public Trie() {
        
    }
    
    public void insert(String word) {
        TrieNode ws = root;
        for(Character ch : word.toCharArray()) {
            if(!ws.edges.containsKey(ch)) {
                ws.edges.put(ch, new TrieNode());
            }
            
            ws = ws.edges.get(ch);
        }    
        ws.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode ws = root;
        for(Character ch : word.toCharArray()) {
            if(!ws.edges.containsKey(ch)) {
                return false;
            }
            
            ws = ws.edges.get(ch);
        }    
        return ws.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(Character ch : prefix.toCharArray()) {
            if(!ws.edges.containsKey(ch)) {
                return false;
            }
            
            ws = ws.edges.get(ch);
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