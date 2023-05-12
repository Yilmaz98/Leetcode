class Solution {
    class Trie {
        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEndWord;
            String wordStr;

            TrieNode() {
                isEndWord = false;

                for(int i=0;i<26;i++) {
                    children[i] = null;
                }
                wordStr = new String();
            }
        };
        
        static TrieNode root;
        
        Trie() {
            root = new TrieNode();
        }
        
        List<String> buff;
 
        
        public void insert(String key) {
            TrieNode curr = root;
            
            for(char c : key.toCharArray()) {
                if(curr.children[c-'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEndWord = true;
            curr.wordStr = key;
         }
        
        public void dfs(TrieNode curr) {
              if (buff.size() == 3)
            return;
            if(curr.isEndWord == true) {
                 buff.add(curr.wordStr);
            }
             
        for (char c = 'a'; c <= 'z'; c++)
            if (curr.children[c - 'a'] != null)
                dfs(curr.children[c - 'a']);
        }
        
        public List<String> search(String key) {
            TrieNode curr = root;
            buff = new ArrayList<>();
            
            for(char c : key.toCharArray()) {
                if(curr.children[c-'a'] == null)
                    return buff;
                curr = curr.children[c-'a'];
            }
            
            dfs(curr);
            return buff;
        }
    };
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        
        for(String product : products) {
            trie.insert(product);
        }
        
        String prefix = new String();
        List<List<String>> result = new ArrayList<>();
        
        for(char c : searchWord.toCharArray()) {
            prefix += c;
            result.add(trie.search(prefix));
        }
        
        return result;
    }
}