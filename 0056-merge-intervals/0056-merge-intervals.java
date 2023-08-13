class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(intervals[0]);
        
        
        for(int i=1;i<intervals.length;i++) {
            if(intervals[i][0] <= q.peekLast()[1]) {
                int[] prev = q.pollLast();
                prev[1] = Math.max(prev[1], intervals[i][1]);
                q.addLast(prev);
            } else {
                q.addLast(intervals[i]);
            }
        }
        
        int[][] result = new int[q.size()][2];
        int idx = 0;
        while(!q.isEmpty()) {
            result[idx++] = q.pollLast();
        }
        
        return result;
    }
}