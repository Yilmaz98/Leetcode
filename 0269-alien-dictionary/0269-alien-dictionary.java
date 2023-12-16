class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
    for (String word : words) {
        for (char c : word.toCharArray()) {
            indegree.put(c, 0);
            adj.put(c, new ArrayList<>());
        }
    }
        
        for(int i=0;i<words.length - 1;i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int m = word1.length();
            int n = word2.length();
            
            if(m > n &&  word1.startsWith(word2)) {
                return "";
            }
            
            for(int k=0;k<Math.min(m, n);k++) {                    
                if(word1.charAt(k) != word2.charAt(k)) {                        
                    adj.get(word1.charAt(k)).add(word2.charAt(k));
                    indegree.put(word2.charAt(k), indegree.get(word2.charAt(k)) + 1);
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        
        for(Character c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                q.add(c);
            }
        }
                
        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()) {
            Character curr = q.poll();
            sb.append(curr);
            
            for(Character nei : adj.getOrDefault(curr, new ArrayList<>())) {
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0)
                    q.add(nei);
            }
        }
        
        if(sb.length() < indegree.size())
            return "";
    
        return sb.toString();
    }
}