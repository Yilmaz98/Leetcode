class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        int[] outdegree = new int[graph.length];
        
        for(int i=0;i<graph.length;i++) { 
            outdegree[i] = graph[i].length;
           for(int j=0;j<graph[i].length;j++) {
                if(!adj.containsKey(graph[i][j])) {
                    adj.put(graph[i][j], new ArrayList<>());
                } 
                    adj.get(graph[i][j]).add(i);
           }
        } 
        
        Queue<Integer> q = new LinkedList<>();  
        List<Integer> result = new ArrayList<>();
        
        for(int i=0;i<outdegree.length;i++) {
            if(outdegree[i] == 0)  {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                  
            Integer curr = q.poll();
            

            if(!adj.containsKey(curr))
                continue;
            
            for(Integer k: adj.get(curr)) {
                outdegree[k]--;
                if(outdegree[k] == 0) {
                    q.add(k);
                }
            }
            }
          
        }
        
        for(int i=0;i<outdegree.length;i++) {
            if(outdegree[i] == 0) {
                result.add(i);
            }
        }
        
        
        return result;
        
    }
}