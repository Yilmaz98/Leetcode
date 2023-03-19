class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie tmp = root;
        for (char c : word.toCharArray()) {
            if (!tmp.containsKey(c)) tmp.add(c);
            tmp = tmp.get(c);
        }
        tmp.isWord = true;
    }
    
    public boolean search(String word) {
        return handleAllValue(root, word, 0);
    }

	private boolean handleAllValue(Trie tmp, String word, int i) {
		if (i >= word.length()) {
			if (tmp.isWord) return true;
			else return false;
		}
		
		if (word.charAt(i) == '.') {
			for (char c = 'a'; c <= 'z'; c++) {
				if (tmp.get(c) != null && handleAllValue(tmp.get(c), word, i+1)) 
						return true;
			}
		} else if (tmp.get(word.charAt(i)) != null) {
			return handleAllValue(tmp.get(word.charAt(i)), word, i+1);
		}
		
		return false;
	}
}

class Trie{
    Trie[] root;
    boolean isWord;
    Trie() {
        root = new Trie[26];
    }
    
    public boolean containsKey(char c){
        return root[c-'a'] != null;
    }
    
    public void add(char c) {
        root[c-'a'] = new Trie();
    }
    
    public Trie get(char c) {
        return root[c-'a'];
    }  
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */