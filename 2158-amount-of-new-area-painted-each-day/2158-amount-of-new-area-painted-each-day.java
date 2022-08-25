class Solution {
    public int[] amountPainted(int[][] paint) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] ans = new int[paint.length];
        int index = 0;
        int start = 0;
        int end = 0;
        int work = 0;
        int prev_end = 0;
        
        for(int[] curr: paint) {
            start = curr[0];
            end = curr[1];
            work = 0;
            while(start < end) {
                if(m.containsKey(start)) {
                    prev_end = m.get(start);
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