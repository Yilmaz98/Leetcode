class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Queue<int[]> q = new LinkedList<>();
        
        Map<Integer, List<Integer>> m = new HashMap<>();
        
        for(int i=0;i<manager.length;i++) {
            if(manager[i] == -1)
                continue;
            if(!m.containsKey(manager[i])) {
                m.put(manager[i], new ArrayList<>());
            }
            m.get(manager[i]).add(i);
        }
        
        int result = 0;
        
        q.add(new int[]{headID, informTime[headID]});
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i=0;i<size;i++) {
            int[] curr = q.poll();
                if(!m.containsKey(curr[0]))
                    continue;
                
                for(Integer neigh : m.get(curr[0])) {
                    int ans = informTime[neigh] + curr[1];
                    result = Math.max(result, ans);
                    q.add(new int[]{neigh, ans});
                }
            }
        }
        
        return result;
    }
}