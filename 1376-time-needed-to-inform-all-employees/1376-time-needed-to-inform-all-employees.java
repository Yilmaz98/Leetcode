class Solution {
    public int dfs(Map<Integer,List<Integer>> m, int headID, int[] informTime) {       
        int max = 0;
        if(!m.containsKey(headID)) {
            return informTime[headID];
        }
        
        for(int i=0;i<m.get(headID).size();i++) {
            max = Math.max(max, informTime[headID] +  dfs(m,m.get(headID).get(i),informTime));
        }    
        return max;  
    } 
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime)     {
        Map<Integer, List<Integer>> m = new HashMap<>();
        
        for(int i=0;i<manager.length;i++) {
            if(manager[i]<0)
                continue;
            if(!m.containsKey(manager[i])) {
                m.put(manager[i], new ArrayList<>());
            }
            
            m.get(manager[i]).add(i);
        }
        
        return dfs(m, headID, informTime);
    }
}