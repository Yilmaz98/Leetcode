class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int result = 1;
        
        for(int[] interval : intervals) {
            if(!pq.isEmpty()) {
                if(pq.peek()[1] <= interval[0]) {
                    pq.poll();
                } else {
                    result++;
                }
            }
            pq.add(new int[]{interval[0], interval[1]});
        }
        
        return result;
        
    }
}