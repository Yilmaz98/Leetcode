class TrieNode {
    Map<Character, TrieNode> childrenMap;
    boolean isWord;
    int wc;
    int pc;
    
    TrieNode() {
        childrenMap = new HashMap<>();
        isWord = false;
        wc = 0;
        pc = 0;
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
            ws.pc += 1;
        }
        ws.wc += 1;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode ws = root;
        
        for(Character c : word.toCharArray()) {
            if(!ws.childrenMap.containsKey(c)) {
                return 0;
            }
            ws = ws.childrenMap.get(c);
        }
        
        return ws.wc;
    }
    
    public int countWordsStartingWith(String prefix) {
        TrieNode ws = root;
        
        for(Character c : prefix.toCharArray()) {
            if(!ws.childrenMap.containsKey(c)) {
                return 0;
            }
            ws = ws.childrenMap.get(c);
        }
        
        return ws.pc;
    }
    
    public void erase(String word) {
        TrieNode ws = root;
        
        for(Character c : word.toCharArray()) {
            if(!ws.childrenMap.containsKey(c)) {
                ws.childrenMap.put(c, new TrieNode());
            }
            ws = ws.childrenMap.get(c);
            ws.pc -= 1;
        }
        ws.wc -= 1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */