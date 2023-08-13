class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int minConferenceRooms = 1;
    
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.offer(new int[]{intervals[0][0], intervals[0][1]});
        for(int i=1;i<intervals.length;i++) {
            int endTime = queue.peek()[1];
            int startTime = intervals[i][0];
            if(endTime > startTime) {
                minConferenceRooms++;
            } else{
                queue.poll();
            }
            queue.offer(new int[]{intervals[i][0],intervals[i][1]});
        }
        
        return minConferenceRooms;
    }
}