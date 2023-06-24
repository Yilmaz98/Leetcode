
class Solution {    
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        if(intervals.length == 0)
            return 0;
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        int ans = 1;
        for(int[] interval : intervals) {
            if(!pq.isEmpty()) 
            {
                int[] prev = pq.peek();
                
                if(prev[1] > interval[0]) 
                    ans++;
                else 
                    pq.poll();
            }
            pq.add(interval);
        }
            
        return ans;
    }
}