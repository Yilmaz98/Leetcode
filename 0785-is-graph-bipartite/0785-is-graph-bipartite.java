class Solution {
    public boolean isBipartite(int[][] graph) {
        int m = graph.length;
        
        int[] colors = new int[m];
        Arrays.fill(colors, -1);
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i = 0;i<m;i++) {
            adj.put(i, new ArrayList<>());
            for(int j=0;j<graph[i].length;j++) {
                adj.get(i).add(graph[i][j]);
            }    
        }
        
        for(int i=0;i<m;i++) {
            if(colors[i] == -1) {
                colors[i] = 0;
                if(!dfs(adj, colors, i))
                    return false;
            }
        }
        
        return true;
    }
    
    public boolean dfs(Map<Integer, List<Integer>> adj,  int[] colors, int src) {
        for(Integer nei : adj.getOrDefault(src, new ArrayList<>())) {
            if(colors[nei] == -1) {
                colors[nei] = colors[src] ^ 1;
                if(!dfs(adj, colors, nei))
                    return false;
            } else {
                if(colors[nei] == colors[src]) {
                    System.out.println(nei + ":" + src);
                    return false;
                }
            }
        }
        
        return true;
    }   
}