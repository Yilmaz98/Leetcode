class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> pathVisited = new HashSet<>();
        
        int m = graph.length;
        
        int[] check = new int[m];
        
        for(int i=0;i<m;i++) {
            if(!visited.contains(i))
                dfs(graph, visited, pathVisited,check, i);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<m;i++) {
            if(check[i] == 1) {
                result.add(i);
            }
        }
        return result;
    }
    
    public boolean dfs(int[][] graph, Set<Integer> visited, Set<Integer> pathVisited, int[] check, int src) {
        visited.add(src);
        pathVisited.add(src);
        
        for(Integer nei : graph[src]) {
            if(!visited.contains(nei)) {
                if(dfs(graph, visited, pathVisited, check, nei))
                    return true;
            } else {
                if(pathVisited.contains(nei))
                    return true;
            }
        }
        
        check[src] = 1;
        pathVisited.remove(src);
        return false;
    }
}