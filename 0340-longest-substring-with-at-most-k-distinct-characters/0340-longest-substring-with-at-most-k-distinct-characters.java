class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> m = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        
        for(int i=0;i<s.length();i++) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
            while(m.size() > k) {
                m.put(s.charAt(start), m.get(s.charAt(start)) - 1);
                if(m.get(s.charAt(start)) == 0)
                    m.remove(s.charAt(start));
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1);
        }
        
        return maxLen;
    }
}