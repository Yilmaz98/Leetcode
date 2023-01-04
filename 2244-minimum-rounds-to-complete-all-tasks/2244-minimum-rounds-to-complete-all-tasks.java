class Solution {
    public int minimumRounds(int[] tasks) {        
        Map<Integer, Integer> m = new HashMap<>();
        int result = 0;
        
        for(int i=0;i<tasks.length;i++) {
            m.put(tasks[i], m.getOrDefault(tasks[i],0)+1);
        }
        
        for(Integer i : m.keySet()) {
            int val = m.get(i);
            
            if(val < 2)
                return -1;
            
            while(val >= 3) {
                result++;
                val -= 3;
            }
            
            while(val >= 2) {
                result++;
                val -= 2;
            }
            
            if(val == 1)
                result++;
        }
        
        return result;
    }
}