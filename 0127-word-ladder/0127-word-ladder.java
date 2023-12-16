class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        words.addAll(wordList);
        words.remove(beginWord);
        
        if(!words.contains(endWord))
            return 0;
                
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        int steps = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++) {
                String curr = q.poll(); 
                
                if(curr.equals(endWord))
                    return steps;
                
                for(int i=0;i<curr.length();i++) {
                    char[] curs = curr.toCharArray();
                    char original = curs[i];
                    
                    for(char c = 'a';c <= 'z';c++) {
                        curs[i] = c;
                        
                        String formedWord = new String(curs);
                        if(words.contains(formedWord)) {
                            words.remove(formedWord);
                            q.add(formedWord);
                        }
                        curs[i] = original;
                    }
                }
            }
            steps++;
        }
        
        return 0;
    }
}