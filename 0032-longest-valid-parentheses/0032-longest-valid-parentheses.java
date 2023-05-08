class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        
        int[] arr = new int[s.length()];
        Arrays.fill(arr,-1);
        
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '(') {
                st.push(i);
            } else {
                    if(!st.isEmpty()) {
                         arr[st.pop()] = 1;
                         arr[i] = 1;
                    } else{
                        continue;
                    }
                }
            }
        
        int ans = 0;
        int maxAns = 0;
        
        for(int i=0;i<arr.length;i++) {
            if(arr[i] == -1) {
                    ans = 0;
            } else {
            ans += arr[i];
            maxAns = Math.max(maxAns, ans); 
            }
        }
        
        return maxAns;
    }
}