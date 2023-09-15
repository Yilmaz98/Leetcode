class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for(List<Integer> sequence : sequences) {
            if(sequence.size() == 1) {
                if(!adj.containsKey(sequence.get(0))) {
                adj.put(sequence.get(0), new HashSet<>());
                if(!indegree.containsKey(sequence.get(0)))
                    indegree.put(sequence.get(0), 0);
                }
            }
            else {
                for(int i = 0;i<sequence.size() - 1;i++) {
                 if(!adj.containsKey(sequence.get(i))) {
                        adj.put(sequence.get(i), new HashSet<>());
                        if(!indegree.containsKey(sequence.get(i)))
                            indegree.put(sequence.get(i), 0);
                    }
                    
                    if(!adj.containsKey(sequence.get(i+1))) {
                        adj.put(sequence.get(i+1), new HashSet<>());
                    }
                    
                        if(adj.get(sequence.get(i)).contains(sequence.get(i+1)))
                            continue;
                    
                     adj.get(sequence.get(i)).add(sequence.get(i+1));
   
                        indegree.put(sequence.get(i+1), indegree.getOrDefault(sequence.get(i+1), 0) + 1);          
            }           
            }  
        }
    
                        System.out.println(indegree);
                
        Set<Integer> dups = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(Integer curr : indegree.keySet()) {
            if(indegree.get(curr) == 0)
                q.add(curr);
        }
    
        int index = 0;
                
        while(!q.isEmpty()) {
            int size = q.size();
            
            if(size > 1)
                return false;

            Integer curr = q.poll();
                    
            index++;
            
            if(!adj.containsKey(curr)) 
                continue;
                
            for(Integer n : adj.get(curr)) {
                indegree.put(n, indegree.get(n) - 1);
    
                if(indegree.get(n) == 0) {
                    q.add(n);
                }
            }
        }
        

          
        return index == nums.length;
    }
}