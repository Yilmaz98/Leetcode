class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0;i<isConnected.length;i++) {
            for(int j=0;j<isConnected[i].length;j++) {
                if(isConnected[i][j] == 1&& i != j) {
                    if(!adj.containsKey(i))
                        adj.put(i, new ArrayList<>());
                    
                    adj.get(i).add(j);
                    
                     if(!adj.containsKey(j))
                        adj.put(j, new ArrayList<>());
                    
                    adj.get(j).add(i);
                }
            }
        }
        
        int n = isConnected.length;
        
        boolean[] visited = new boolean[n];
        
        int provinces = 0;
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                provinces++;
                dfs(adj, visited, i);
            }
        }
        
        return provinces;
    }
    
    public void dfs(Map<Integer, List<Integer>> adj, boolean[] visited, int curr) {
        visited[curr] = true;
        
        if(!adj.containsKey(curr))
            return;
        
        for(Integer nei : adj.get(curr)) {
            if(!visited[nei]) {
                dfs(adj, visited, nei);
            }
        }
    }
}