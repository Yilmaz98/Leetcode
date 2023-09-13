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
        
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        
        Set<Integer> visited = new HashSet<>();
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            visited.add(curr);    
            
            if(curr == destination) {
                return true;
            }
            
            if(!adj.containsKey(curr))
                continue;
            
            for(int ne : adj.get(curr)) {
                if(!visited.contains(ne)) {
                    visited.add(ne);
                    q.add(ne);
                }   
            }
        }
        
        
        return false;
    }
}