class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] start = new int[len];
        int[] end = new int[len];
        
        for(int i=0;i<len;i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
         int endInc = 0;
        int rooms = 0;
        for (int i=0; i<len; i++) {
            if (start[i] < end[endInc]) {
                rooms++;
            } else {
                endInc++;
            }
        }
        return rooms;
    }
}