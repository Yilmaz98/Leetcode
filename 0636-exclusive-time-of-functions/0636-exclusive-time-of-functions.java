class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> st = new Stack<>();
        
        int[] allTimes = new int[n];
        int prev = 0;
        
        for(int i=0;i<logs.size();i++) {
            String[] curr = logs.get(i).split(":");
            int func = Integer.parseInt(curr[0]);
            boolean start = curr[1].equals("start") ? true: false;
            int time = Integer.parseInt(curr[2]);
            
            if(!start) {
                time++;
            }
            if(!st.isEmpty())
                allTimes[st.peek()] += time - prev;
            if(start) {
                st.push(func);
            } else {
                st.pop();
            }
            prev = time;
        }
        
        return allTimes;
    }
}