class Solution {
    public int findCircleNum(int[][] isConnected) {        
        int n = isConnected.length;
        boolean[] visited = new boolean[n + 1];
        int provinces = 0;
        
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                provinces++;
                dfs(visited, i, isConnected);
            }
        }
        
        return provinces;
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