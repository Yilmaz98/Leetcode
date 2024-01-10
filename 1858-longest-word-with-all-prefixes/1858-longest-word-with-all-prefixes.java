class Solution {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isPrefixPresent;
        
        TrieNode() {
            children = new HashMap<>();
            isPrefixPresent = false;
        }
        
    }
    
    class Trie {
        TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode ws = root;
            
            for(Character c : word.toCharArray()) {
                if(!ws.children.containsKey(c)) {
                    ws.children.put(c, new TrieNode());
                }
                ws = ws.children.get(c);
            }
            ws.isPrefixPresent = true;
        }
        
        public boolean isAllPrefixPresent(String word) {
            TrieNode ws = root;
            
            for(Character c : word.toCharArray()) {
                if(!ws.children.containsKey(c)) {
                    return false;
                }
                ws = ws.children.get(c);
                if(!ws.isPrefixPresent)
                    return false;
            }
            
            return true;
        }
    }
    
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        
        for(String word : words) {
            trie.insert(word);    
        }
        
        String result = "";
        
        int longest = 0;
        for(String word : words) {
            if(trie.isAllPrefixPresent(word)) {
                if(longest < word.length()) {
                    longest = word.length();
                    result = word;
                } else if(longest == word.length()) {
                    if(word.compareTo(result) < 0)  {
                        result = word;
                    }
                }
            }
        }
        
        return result;
    }
}