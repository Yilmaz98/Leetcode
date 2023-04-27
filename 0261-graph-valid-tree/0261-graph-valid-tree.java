class Solution {
    public boolean validTree(int n, int[][] edges) {     
        if(n == 1)
            return true;
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] edge: edges) {
            if(!adj.containsKey(edge[0]))
                adj.put(edge[0], new ArrayList<>());
            
            if(!adj.containsKey(edge[1]))
                adj.put(edge[1], new ArrayList<>());
            
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(0);
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            if(visited.contains(curr))
                return false;
            visited.add(curr);
            
            if(!adj.containsKey(curr))
                return false;
            
            for(Integer nei : adj.get(curr)) {
                if(!visited.contains(nei))
                    q.add(nei);
            }
        }
        
        if(visited.size() < n)
            return false;
        
        return true;
        
    }
}