class Trie {
    public class TrieNode {
        boolean isWord;
        TrieNode[] children;
        
        
        TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    
    TrieNode root = new TrieNode();
    public Trie() {
     
    }
    
    public void insert(String word) {
        TrieNode ws = root;
        for(char c : word.toCharArray()) {
            if(ws.children[c-'a'] == null) {
                ws.children[c-'a'] = new TrieNode();
            } 
            ws = ws.children[c-'a'];
        }
        ws.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode ws = root;
        for(char c : word.toCharArray()) {  
            if(ws.children[c-'a'] == null) {
                return false;
            } 
            ws = ws.children[c-'a'];
        }
       return ws.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for(char c : prefix.toCharArray()) {  
            if(ws.children[c-'a'] == null) {
                return false;
            } 
            ws = ws.children[c-'a'];
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