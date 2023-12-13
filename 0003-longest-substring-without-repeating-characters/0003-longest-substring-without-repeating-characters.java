class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> m = new HashMap<>();
        int length = s.length();
        int maxLen = 0;
        int start = 0;
        
        for(int end=0;end<length;end++) {
            if(m.containsKey(s.charAt(end))) {
                start = Math.max(start, m.get(s.charAt(end))  + 1);
            }
            
            m.put(s.charAt(end), end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
}