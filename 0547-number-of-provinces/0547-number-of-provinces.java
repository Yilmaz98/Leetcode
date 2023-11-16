class Solution {
    public int findCircleNum(int[][] isConnected) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        
        for(int i=0;i<isConnected.length;i++) {
            for(int j=0;j<isConnected[0].length;j++) {
                if(i != j && isConnected[i][j] == 1) {
                    if(!m.containsKey(i))
                        m.put(i, new ArrayList<>());
                    m.get(i).add(j);
                }
            }
        }
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n + 1];
        int provinces = 0;
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                provinces++;
                dfs(m, visited, i);
            }
        }
        
        return provinces;
    }
    
    public void dfs(Map<Integer, List<Integer>> m , boolean[] visited, int i) {
        visited[i] = true;
        if(!m.containsKey(i))
            return;
        for(Integer nei : m.get(i)) {
            if(!visited[nei]) {
                dfs(m, visited, nei);
            }
        }
    }
}