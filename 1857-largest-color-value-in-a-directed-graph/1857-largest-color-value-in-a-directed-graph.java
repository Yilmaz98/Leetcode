class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];
        
        for(int[] edge: edges) {
            adj.computeIfAbsent(edge[0], k->new ArrayList<Integer>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
    
        for(int i=0;i<n;i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }
        
        int nodesVisited = 0;
        int result = 1;
        
        int[][] colormap = new int[n][26];
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            nodesVisited++;
            colormap[curr][colors.charAt(curr) - 'a']++;
            result = Math.max(result, colormap[curr][colors.charAt(curr) - 'a']);
            
            if(!adj.containsKey(curr))
                continue;
            
            for(Integer neigh: adj.get(curr)) {
                
                for(int i=0;i<26;i++) {
                    colormap[neigh][i] = Math.max(colormap[curr][i], colormap[neigh][i]);
                }
                
                indegree[neigh]--;
                
                if(indegree[neigh] == 0)
                    q.offer(neigh);
            }
        }
        
        if(nodesVisited < n)
            return -1;
        else 
            return result;
        
    }
}