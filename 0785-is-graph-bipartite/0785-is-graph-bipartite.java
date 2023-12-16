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
    
    public boolean dfs(Map<Integer, List<Integer>> adj,  int[] colors, int start) {
                Stack<Integer> stack = new Stack();
                stack.push(start);
                colors[start] = 0;

                while (!stack.empty()) {
                    Integer node = stack.pop();
                    for (int nei: adj.getOrDefault(node, new ArrayList<>())) {
                        if (colors[nei] == -1) {
                            stack.push(nei);
                            colors[nei] = colors[node] ^ 1;
                        } else if (colors[nei] == colors[node]) {
                            return false;
                        }
                    }
                }
    
        return true;
    }   
}