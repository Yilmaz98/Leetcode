class Solution {
    public int[] amountPainted(int[][] paint) {
        Map<Integer, Integer> m = new HashMap<>();
        
        int[] ans = new int[paint.length];
        int index = 0;
        for(int[] curr: paint) {
            int start = curr[0];
            int end = curr[1];
            int work = 0;
            while(start < end) {
                if(m.containsKey(start)) {
                    int prev_end = m.get(start);
                    m.put(start, Math.max(m.get(start), end));
                    start = prev_end;
                    
                } else {
                 m.put(start, end);
                    start+=1;
                work += 1; 
                }
              
            }
            ans[index] = work;
            index++;
        }
        
        return ans;
    }
}