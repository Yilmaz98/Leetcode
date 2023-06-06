class Solution {
    public int lengthOfLongestSubstring(String s) {
       int start = 0, end = 0, minStart = 0, len = 0;
        
        int[] map = new int[128];
        
        while(end < s.length()) {
            char c1 = s.charAt(end);
            map[c1]++;
            end++;
            
            while(map[c1] > 1) {            
                char c2 = s.charAt(start);
                map[c2]--;
                start++;
            }
            
            if(len < end - start) {
                len = end - start;
                minStart = start;
            }
        }
        
        return len;
    }
}