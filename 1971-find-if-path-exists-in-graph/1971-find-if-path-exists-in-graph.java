class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges) {
            if(!adj.containsKey(edge[0]))
                adj.put(edge[0], new ArrayList<>());
              if(!adj.containsKey(edge[1]))
                adj.put(edge[1], new ArrayList<>());
            
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        
        
        return dfs(source, adj, destination, new HashSet<>());
    }
    
    public boolean dfs(int curr, Map<Integer, List<Integer>> adj, int destination, Set<Integer> visited) { 
        if(visited.contains(curr))
            return false;
        
        visited.add(curr);
        
        if(curr == destination) {
            return true;
        }
                
        if(!adj.containsKey(curr))
            return false;
        
        for(int n : adj.get(curr)) {
            if(!visited.contains(n)) {
                if(dfs(n, adj, destination, visited)) {
                   return true; 
                }
                    
            }
        }
        
        return false;
    }
}