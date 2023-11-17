class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] pathVisited = new boolean[V];
        int[] check = new int[V];
        
        for(int i=0;i<V;i++) {
            if(!visited[i]) {
                dfs(graph, visited, pathVisited, i, check);
            }
        } 
        
        for(int i=0;i<V;i++) {
            if(check[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }
    
    public boolean dfs(int[][] graph, boolean[] visited, boolean[] pathVisited, int src, int[] check) {
        visited[src] = true;
        pathVisited[src] = true;
        check[src] = 0;
        
        for(int nei : graph[src]) {
            if(!visited[nei]) {
                if(dfs(graph, visited, pathVisited, nei, check)) {
                    check[src] = 0;
                    return true;
                }
            } else if(pathVisited[nei]) {
                    check[src] = 0;
                    return true;
                }
        }
        
        check[src] = 1;
        pathVisited[src] = false;
        return false;
    }
}