class Solution {
    public int[][] merge(int[][] intervals) {
    
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
       Stack<int[]> st = new Stack<>();
       st.push(intervals[0]);
           
       for(int i=1;i<intervals.length;i++) {
           int[] prev = st.peek();
           if(!st.isEmpty() && prev[1] >= intervals[i][0]) {
                st.pop();
                int[] newInterval = new int[2];
                newInterval[0] = Math.min(prev[0], intervals[i][0]);
                newInterval[1] = Math.max(intervals[i][1], prev[1]);
                st.push(newInterval);
           } 
           else {
               st.push(intervals[i]);
           }
       }
        
       int[][] ans = new int[st.size()][2];
        
        for(int i=ans.length-1;i>=0;i--) {
            ans[i] = st.pop();
        }
        
        return ans;
    }
}