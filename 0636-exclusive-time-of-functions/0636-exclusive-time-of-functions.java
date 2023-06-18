class Solution {
   public int[] exclusiveTime(int n, List<String> logs) {
		int[] res = new int[n];
		Deque<Integer> stack = new LinkedList<>();
		int prevTime = 0;

		for (String log : logs) {
			String[] split = log.split(":");
			int funcId = Integer.parseInt(split[0]);
			boolean isStart = split[1].equals("start");
			int time = Integer.parseInt(split[2]);
			if (!isStart) time++;

			if (!stack.isEmpty()) {
				res[stack.peek()] += time - prevTime;
			}
			if (isStart) stack.push(funcId);
			else stack.pop();
			prevTime = time;
		}
		return res;
	}
}