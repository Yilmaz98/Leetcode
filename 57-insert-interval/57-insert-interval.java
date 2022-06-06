class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      int i = 0;
      List<int[]> result = new ArrayList<>();
        
      while(i < intervals.length && intervals[i][1] < newInterval[0])       {
          result.add(intervals[i++]);
      }
    
      
      while(i < intervals.length && intervals[i][1] >= newInterval[0] && intervals[i][0] <= newInterval[1]) {
          newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
          newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
          i++;
      }
         result.add(newInterval);
        
    while(i<intervals.length) {
       result.add(intervals[i]);
        i++;
    }
        
        System.out.println(result);
        return result.stream().map(u -> u).toArray(int[][]::new);
    }
}