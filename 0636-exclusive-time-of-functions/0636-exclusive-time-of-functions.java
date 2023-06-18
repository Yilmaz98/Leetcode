class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        int prevtime = 0;
        
        for(int i=0;i<logs.size();i++) {
            String[] vals = logs.get(i).split(":");
            int func = Integer.parseInt(vals[0]);
            boolean start = vals[1].equals("start");
            int time = Integer.parseInt(vals[2]);
            if(!start)
                time++;
            
            if(!st.isEmpty())
                result[st.peek()] += time - prevtime;
            if(start) {
                st.push(func);
            } else {
                st.pop();
            }
            prevtime = time;
        }
        
        return result;
    }
}