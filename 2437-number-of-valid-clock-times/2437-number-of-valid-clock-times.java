class Solution {
    public int countTime(String time) {
        if(time.equals("??:??"))
            return 1440;
        
        int result = 1;
        
        if(time.charAt(4) == '?') {
             result *= 10;
        }
           
        
        if(time.charAt(3) == '?')
            result *= 6;
        
        if(time.charAt(0) == '?' && time.charAt(1) == '?')
            result *=24;
        else if(time.charAt(1) == '?'){
            if(Integer.parseInt(String.valueOf(time.charAt(0))) < 2) {
                result *= 10;
            } else {
                result *=4;
            }
        }
        else if(time.charAt(0) == '?'){
            if(Integer.parseInt(String.valueOf(time.charAt(1))) < 4) {
                result *= 3;
            } else {
                result *=2;
            }
        }
        
        return result;
    }
}