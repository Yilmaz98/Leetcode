class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 1)
            return 1;
        Map<Character, Integer> m = new HashMap<>();
        
        int j = 0;
        int maxLen = 0;
        for(int i=0;i<s.length();i++) {
            if(m.containsKey(s.charAt(i))) {
                j = Math.max(j,m.get(s.charAt(i))+1);
            }
            maxLen = Math.max(maxLen, i-j + 1);
            m.put(s.charAt(i),i);
        }
        
        
        return maxLen;
    }
}