class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;
    int prefixCount;
    int wordCount;
    
    TrieNode() {
        children = new HashMap<>();
        isWord = false;
        prefixCount = 0;
        wordCount = 0;
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
            if(!ws.children.containsKey(c)) {
               ws.children.put(c, new TrieNode());
            }
            ws = ws.children.get(c);
            ws.prefixCount += 1;
        }
        
        ws.isWord = true;
        ws.wordCount += 1;
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode ws = root;
        
        for(Character c : word.toCharArray()) {
            if(ws.children.containsKey(c))
                ws = ws.children.get(c);
            else 
                return 0; 
        }
        
        return ws.wordCount;
    }
    
    public int countWordsStartingWith(String prefix) {
         TrieNode ws = root;
        
        for(Character c : prefix.toCharArray()) {
            if(!ws.children.containsKey(c))
                return 0;
            ws = ws.children.get(c);
        }
        
        return ws.prefixCount;
    }
    
    public void erase(String word) {
        TrieNode ws = root;
        
        for(Character c : word.toCharArray()) {
            if(ws.children.containsKey(c)) {
                ws = ws.children.get(c);
                ws.prefixCount -= 1;
            } else 
                return;     
        }
        
        ws.wordCount -= 1;
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