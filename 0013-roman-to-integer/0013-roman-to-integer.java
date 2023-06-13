class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> m = new HashMap<>();
         m.put("I",1);
         m.put("V",5);
         m.put("X",10);
         m.put("L",50);
         m.put("C",100);
         m.put("D",500);
         m.put("M",1000);
         m.put("CM",900);
         m.put("XC",90);
         m.put("IV",4);
         m.put("IX",9);
         m.put("XL",40);
         m.put("CD",400);
        
        if(s.length() == 1)
            return m.get(s.substring(0,1));
        
        int result = 0;
        
        for(int i=0;i<s.length() -1;i++) {
            int curr = m.get(s.substring(i,i+1));

            if(m.containsKey(s.substring(i,i+2))) {
                result += m.get(s.substring(i,i+2));
                i++;
            } else {
                result += curr;
            }
        }
        
        int n = s.length();
        
        if(!m.containsKey(s.substring(n-2,n))) {
            result += m.get(s.substring(n-1,n));
        }
        
        return result;
    }
}