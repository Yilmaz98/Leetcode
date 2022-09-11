class Solution {
    public boolean judgeCircle(String moves) {
        int ud = 0;
        int lr = 0;
        
        for(char c : moves.toCharArray()) {
            if(c == 'L') {
               lr++;
            }
            
            if(c == 'R') {
               lr--;
            }
                
            if(c == 'U') {
               ud++;
            }
            
            if(c == 'D') {
               ud--;
            }
        }
        
        return lr == 0 && ud == 0;
    }
}