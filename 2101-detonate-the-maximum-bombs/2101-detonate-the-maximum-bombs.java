class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0;i<bombs.length;i++) {
            for(int j=0;j<bombs.length;j++) {
                if (i == j) {
                    continue;
                }
                
                int xi = bombs[i][0];
                int yi = bombs[i][1];
                int ri = bombs[i][2];
                
                int xj = bombs[j][0];
                int yj = bombs[j][1];
                
                  // Create a path from node i to node j, if bomb i detonates bomb j.
                if ((long)ri * ri >= (long)(xi - xj) * (xi - xj) + (long)(yi - yj) * (yi - yj)) {
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        
        int maxCount = 0;
        
       for(int i=0;i<bombs.length;i++) {
             maxCount = Math.max(maxCount, dfs(adj, new HashSet<>(), i));
       }
        
        return maxCount;
    }
    
    public int dfs(Map<Integer, List<Integer>> adj, Set<Integer> visited, int source) {        
        visited.add(source);
        int count = 1;
        for(Integer nei : adj.getOrDefault(source, new ArrayList<>())) {
            if(!visited.contains(nei)) {
                count += dfs(adj, visited, nei);
            }
        }
        
        return count;
    }
}