class Solution {
    public int maximumDetonation(int[][] bombs) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        
        for(int i=0;i<bombs.length;i++) {
            long x1 = bombs[i][0];
            long y1 = bombs[i][1];
            long r1 = bombs[i][2];
            
            for(int j = 0 ;j< bombs.length;j++) {
                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long r2 = bombs[j][2];
                
                if(i!=j) {
                    long a = (x1-x2) *(x1-x2);
                    long b = (y1-y2)*(y1-y2);
                    long c = r1*r1;
                    if( a + b  <= c) {
                        if(!adj.containsKey(i)) {
                            adj.put(i, new ArrayList<>());
                        }
                        
                        adj.get(i).add(j);
                    }
                }
            }
        }
        
        //System.out.println(adj);
        
        int count = 0;
        int maxCount = 1;
        
        for(int i=0;i<bombs.length;i++) {
            count = bfs(adj,i);
            maxCount = Math.max(maxCount, count);
        }
        
        return maxCount;
    }
    
    public int bfs(Map<Integer, List<Integer>> adj, int startIndex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startIndex);
        
        Set<Integer> visited = new HashSet<>();
        visited.add(startIndex);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                Integer curr = q.poll();
                
                if(adj.containsKey(curr)) {
                    for(Integer n : adj.get(curr)) {
                        if(!visited.contains(n)) {
                             visited.add(n);
                                q.add(n);
                        }  
                    }
                }
            }
        }
        
        return visited.size();
    }
}