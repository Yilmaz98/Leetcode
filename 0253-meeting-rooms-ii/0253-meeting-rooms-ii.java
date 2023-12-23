class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        
        if (n == 0) {
            return 0;
        }
        
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int i=0;i<intervals.length;i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        
        
        int minConferenceRooms = 0;
        
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < n) {
            if(start[p1] >= end[p2]) {
                minConferenceRooms--;
                p2++;
            }
            minConferenceRooms++;
            p1++;
        }
        
        return minConferenceRooms;
    }
}