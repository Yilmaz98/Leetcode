class Solution {
    public int findCircleNum(int[][] isConnected) {        
        int n = isConnected.length;
        boolean[] visited = new boolean[n + 1];
        int provinces = 0;
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                provinces++;
                bfs(visited, i, isConnected);
            }
        }
        
        return provinces;
    }
    
    public void bfs(boolean[] visited, int i, int[][] isConnected) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            
            for(int j=0;j<isConnected[curr].length;j++) {
            if(curr != j && isConnected[curr][j] == 1 && !visited[j]) {
                q.add(j);
                visited[j] = true;
             }
            }
        }
    }
    
    public void dfs(boolean[] visited, int i, int[][] isConnected) {
        visited[i] = true;
       
        for(int j=0;j<isConnected[i].length;j++) {
            if(i != j && isConnected[i][j] == 1 && !visited[j]) {
                dfs(visited, j, isConnected);
            }
        }
    }
}