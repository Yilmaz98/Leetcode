class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
           int[] res = new int[n];
        int ptime = 0, running = 0;
        Stack<Integer> stack = new Stack<>();

        for (String log : logs) {
            String[] split = log.split(":");
            int func = Integer.parseInt(split[0]);
            boolean start = split[1].equals("start");
            int time = Integer.parseInt(split[2]);
            if (!start)
                time++;

            res[running] += (time - ptime);
            if (start) {
                stack.push(running);
                running = func;
            } else {
                running = stack.pop();
            }
            ptime = time;
        }
        return res;
        }
}