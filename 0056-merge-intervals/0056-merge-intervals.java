class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1)
            return intervals;
        
        Stack<int[]> st = new Stack<>();
        
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        for(int i=0;i<intervals.length;i++) {
            if(st.isEmpty()) {
                st.push(intervals[i]);
            } else {
                int[] prev = st.peek();
                int[] curr = intervals[i];
                
                if(prev[1] >= curr[0]) {
                    st.pop();
                    st.push(new int[]{prev[0], Math.max(prev[1],curr[1])});
                } else {
                    st.push(curr);
                }
                
            }
        }
        
        int[][] arr = new int[st.size()][2];
        
        for(int i = arr.length - 1;i>=0;i--) {
            arr[i] = st.pop();
        }
        
        return arr;
    }
}