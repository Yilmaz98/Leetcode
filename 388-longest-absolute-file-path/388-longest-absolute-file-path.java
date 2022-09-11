class Solution {
    public int lengthLongestPath(String input) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int result = 0;
        
        String[] curr = input.split("\n");
        
        for (String s : curr) {
            int level = s.lastIndexOf('\t') + 1;
            System.out.println(s + ":" + level);
            int len = s.length() - level;
            while (stack.size() > level + 1) {
                stack.pop();
            }
            if (s.contains(".")) {
                result = Math.max(result, stack.peek() + len);
            } else {
                stack.push(stack.peek() + len + 1);
            }
        }
        return result;
    }
}