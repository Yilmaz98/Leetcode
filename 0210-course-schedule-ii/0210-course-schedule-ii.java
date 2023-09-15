class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        
        for(int[] prereq : prerequisites) {
            indegree[prereq[0]]++;
        }
        
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int[] curr : prerequisites) {
            if(!adj.containsKey(curr[1])) {
                adj.put(curr[1], new ArrayList<>());
            }
            
            adj.get(curr[1]).add(curr[0]);
         }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i] == 0) {
                 q.add(i);
            }
        }
        
        int[] order = new int[numCourses];
        int index = 0;
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            order[index++] = curr;
            
            if(!adj.containsKey(curr))
                continue;
            
            for(Integer nei : adj.get(curr)) {
                if(--indegree[nei] == 0)
                    q.add(nei);
            }
        }
        
        if(index != numCourses)
            return new int[0];
        return order;
    }
}