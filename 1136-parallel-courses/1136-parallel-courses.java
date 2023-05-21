class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n+1];
        
        for(int i=0;i<relations.length;i++) {
            if(!adj.containsKey(relations[i][0]))
                adj.put(relations[i][0], new ArrayList<>());
                
            adj.get(relations[i][0]).add(relations[i][1]);
            indegree[relations[i][1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i=1;i<indegree.length;i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        if(q.isEmpty())
            return -1;
        
        int result = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int k =0;k<size;k++) {
            Integer curr = q.poll();
            visited.add(curr);
            
            if(!adj.containsKey(curr))
                continue;
            
            for(Integer i: adj.get(curr)) {
                if(--indegree[i] == 0) {
                    q.add(i);
                }
            }
            }
            result++;
        }
    
        
        return visited.size() == n ? result : -1;
    }
}