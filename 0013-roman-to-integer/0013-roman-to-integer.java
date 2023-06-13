class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> m = new HashMap<>();
         m.put('I',1);
         m.put('V',5);
         m.put('X',10);
         m.put('L',50);
         m.put('C',100);
         m.put('D',500);
         m.put('M',1000);
        
        if(s.length() == 1)
            return m.get(s.charAt(0));
        
        int result = 0;
        
        for(int i=0;i<s.length() -1;i++) {
            int curr = m.get(s.charAt(i));
            int next = m.get(s.charAt(i+1));
            
            if(curr < next) {
                 result += (next - curr); 
                 i++;
            } else {
                result += curr;
            }
        }
        int n = s.length();
        int curr = m.get(s.charAt(n-2));
        int next = m.get(s.charAt(n-1));
        
        if(curr >= next)
            result +=next;
        
        return result;
    }
}