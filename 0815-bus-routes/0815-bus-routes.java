class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        
        for(int i=0;i<routes.length;i++) {
            for(int j=0;j<routes[i].length;j++) {
                if(!m.containsKey(routes[i][j]))
                    m.put(routes[i][j],new ArrayList<>());
                
                m.get(routes[i][j]).add(i);
            }
        }
        
        int result = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(source);  
        Set<Integer> buses = new HashSet<>();

        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
                Integer curr = q.poll();
                
                if(curr == target)
                    return result;
                
                for(Integer bus : m.get(curr)) {
                    if(buses.contains(bus))
                            continue;
                    for(int j=0;j<routes[bus].length;j++) {
                        q.add(routes[bus][j]);
                    }
                    buses.add(bus);
                }
            }
            result++;
        }
        
        return -1;
    }
}