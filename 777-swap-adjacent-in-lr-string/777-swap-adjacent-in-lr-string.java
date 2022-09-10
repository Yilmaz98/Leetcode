class Solution {
    public boolean canTransform(String start, String end) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : start.toCharArray()) {
            if(c!='X')
                sb.append(c);
        }
        
        StringBuilder sb2 = new StringBuilder();
        
        for(char c : end.toCharArray()) {
            if(c!='X')
                sb2.append(c);
        }
        
        if(!sb.toString().equals(sb2.toString()))
            return false;
        
        List<Integer> startL = new ArrayList<>();
        List<Integer> startR = new ArrayList<>();
        
        List<Integer> endL = new ArrayList<>();
        List<Integer> endR = new ArrayList<>();
        
        
        for(int i=0;i<start.length();i++) {
            if(start.charAt(i) == 'L')
                startL.add(i);
             if(start.charAt(i) == 'R')
                startR.add(i);
        }
        
         for(int i=0;i<end.length();i++) {
            if(end.charAt(i) == 'L')
                endL.add(i);
             if(end.charAt(i) == 'R')
                endR.add(i);
        }
        
        for(int i=0;i<startL.size();i++) {
            if(endL.get(i) <= startL.get(i)) {
                continue;
            }
            else{
                return false;
            }
        }
        
        for(int i=0;i<startR.size();i++) {
            if(endR.get(i) >= startR.get(i)) {
                continue;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
}