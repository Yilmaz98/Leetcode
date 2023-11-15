class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1];
        backtrack(n, 1, visited);
        return count;
    }
    
    
    public void backtrack(int n, int index, boolean[] visited) {
        if(index > n) {
            count++;
        }
        
        for(int i=1;i<=n;i++) {
            if(visited[i] || (i % index != 0 && index % i != 0))
                continue;
            visited[i] = true;
            backtrack(n, index+1, visited);
            visited[i] = false;
        }
    }
}