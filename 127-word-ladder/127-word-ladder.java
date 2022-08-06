class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
        
        wordList.add(beginWord);
        
        Map<String, List<String>> adj = new HashMap<>();
        
        for(int i=0;i<wordList.size();i++) {
            for(int j=0;j<wordList.get(i).length();j++) {
                String pattern = wordList.get(i).substring(0,j) + "*" +  wordList.get(i).substring(j+1,wordList.get(i).length());
                if(!adj.containsKey(pattern))
                    adj.put(pattern, new ArrayList<>());
                
                List<String> curr = adj.get(pattern);
                curr.add(wordList.get(i));
                adj.put(pattern, curr);
            }
        }
    
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int res = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int k=0;k<size;k++) {
                String curr = q.poll();
                if(curr.equals(endWord)) {
                    return res;
                }
                for(int i=0;i<curr.length();i++) {
                    String pattern = curr.substring(0,i) + "*" + curr.substring(i+1,curr.length());
                    if(adj.containsKey(pattern)) {
                        List<String> foundList = adj.get(pattern);
                        for(String s : foundList) {
                            if(!visited.contains(s)){
                                q.offer(s);
                                visited.add(s);
                            }       
                        }
                    }
                }
            }
            res++;    
        }
    
        return 0;
     }
}