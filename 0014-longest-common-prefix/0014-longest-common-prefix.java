class Solution {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        
        if(strs.length == 1)
            return strs[0];
        
        for(int i=0;i<strs.length -1;i++) {
            trie.insert(strs[i]);
        }
        
        return trie.getLongestPrefix(strs[strs.length - 1]);
    }
}

class Trie {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;
        int count;
        
        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
            count = 0;
        }
    }
    
    TrieNode root = new TrieNode();
    
    public void insert(String s) {
        TrieNode ws = root;
        
        for(int i = 0;i<s.length();i++) {
            Character ch = s.charAt(i);
            
            if(!ws.children.containsKey(ch)) {
                ws.children.put(ch, new TrieNode());
                ws.count++;
            } 
            ws = ws.children.get(ch);
        }
        ws.isEnd = true;
    }
    
    public String getLongestPrefix(String s) {
        TrieNode ws = root;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0;i<s.length();i++) {
            Character ch = s.charAt(i);
            
            if(!ws.children.containsKey(ch) || ws.count != 1 || ws.isEnd == true) {
                return sb.toString();
            } 
            sb.append(ch);
            ws = ws.children.get(ch);
        }
        
        return sb.toString();
    }
}