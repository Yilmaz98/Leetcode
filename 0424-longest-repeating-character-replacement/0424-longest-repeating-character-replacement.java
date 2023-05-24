class Solution {
    public int characterReplacement(String s, int k) {
        int result = 0;
        int start = 0;
        int end  = 0;
        int len = 0;
        
       Map<Character,Integer> m = new HashMap<>();
        int maxCount = 0;
        
        while(end < s.length()) {
            m.put(s.charAt(end), m.getOrDefault(s.charAt(end),0) + 1);
            maxCount = Math.max(maxCount, m.get(s.charAt(end)));
            len = end - start + 1;
            
            if(len - maxCount <= k) {
                result = Math.max(result, len);
            } else{
                m.put(s.charAt(start), m.get(s.charAt(start)) - 1);
                start++;   
            }        
            end++;
        }
        
        return result;
    }
}