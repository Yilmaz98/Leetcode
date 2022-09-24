class Solution {
    public int removeStones(int[][] stones) {
        if(stones.length <= 1) {
            return 0;
        }
        
        int ans = 0;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0;i<stones.length;i++) {
         {
            for(int j=0;j<stones.length;j++) {
            if(i != j) {
            if(stones[i][0] != stones[j][0] && stones[i][1] != stones[j][1]) 
                             continue;
                if(!adj.containsKey(i)) {
                    adj.put(i, new ArrayList<>());
                }
                    adj.get(i).add(j);   
            }  
        }
        }
            
        }
        
        //System.out.println(adj);
        
        Set<Integer> visited = new HashSet<>();
        int componentsCount = 0;
        for(int i=0;i<stones.length;i++) {
            if(!visited.contains(i)) {
               dfs(adj,i, visited);
               componentsCount++;
            }
        }
        
        return stones.length - componentsCount;
    }
    
    public int dfs(Map<Integer, List<Integer>> adj, int i, Set<Integer> visited) {
        if(!adj.containsKey(i)) {
            return 0;
        }
        for(Integer j : adj.get(i)) {
            if(!visited.contains(j)) {
                visited.add(j);
                dfs(adj,j,visited);
            }
        }
        
        return visited.size();
    }
    
}