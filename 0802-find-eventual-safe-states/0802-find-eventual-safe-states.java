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
                result.add(i);
                q.add(i);
            }
        }

        
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            System.out.println(curr);
            
            if(!adj.containsKey(curr) || adj.get(curr).size() == 0)
                continue;
            
            for(Integer i: adj.get(curr)) {
                outdegree[i]--;
                if(outdegree[i] == 0) {
                    q.add(i);
                         result.add(i);
                }
            }
        }
        
        Collections.sort(result);
        
        return result;
        
    }
}