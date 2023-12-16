class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] curr: prerequisites) {
            if(!adj.containsKey(curr[1])) {
                adj.put(curr[1], new ArrayList<>());
            }
            
            adj.get(curr[1]).add(curr[0]);
            indegree[curr[0]]++;
        }
        
        System.out.println(adj);
        
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<numCourses;i++) {
            if(indegree[i] == 0)
                q.add(i);
        }
        
        int sizes = 0;
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            sizes++;
            
            for(Integer nei : adj.getOrDefault(curr, new ArrayList<>())) {
                if(--indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        
        return sizes == numCourses;
    }
}