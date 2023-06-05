class Solution {
    public String minWindow(String s, String t) {
        int[] m = new int[128];
        
        for(char c: t.toCharArray()) {
            m[c]++;
        }
        
        int start = 0, end = 0, len = Integer.MAX_VALUE, counter = t.length(), minStart = 0;
        
        while(end < s.length()) {
            char c1 = s.charAt(end);
            if(m[c1] > 0)
                counter--;
            m[c1]--;
            end++;
            
            while(counter == 0) {
                
                if(end - start < len) {
                    len = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                
                m[c2]++;
                if(m[c2] > 0)
                    counter++;
                start++;
            } 
        }
        
        return len == Integer.MAX_VALUE? "" : s.substring(minStart, minStart + len);
    }
}