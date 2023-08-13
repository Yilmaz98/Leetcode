class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> m = new TreeMap<>();
        
        for(int i=0;i<logs.length;i++) {
            m.put(logs[i][0], m.getOrDefault(logs[i][0],0)+1);
            m.put(logs[i][1], m.getOrDefault(logs[i][1],0)-1);
        }
        
        int result = 0;
        int sum = 0;
        int year = -1;
        for(Integer curr : m.keySet()) {
            sum += m.get(curr);
            if(sum > result) {
                year = curr;
                result = Math.max(result, sum);
            }
            
        }
        
        return year;
    }
}