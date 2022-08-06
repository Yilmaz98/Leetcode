class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        
        Map<Character, Integer> m = new HashMap<>();      
        int i = 0;
        int j = 0;
        
        int maxLength = 1;
        
        while(j < s.length()) {
            if(m.containsKey(s.charAt(j))) {
                i = Math.max(i,m.get(s.charAt(j)) + 1);
            }
            m.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }
        
        return maxLength;
    }
}