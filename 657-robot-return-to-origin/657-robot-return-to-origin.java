class Solution {
    public boolean judgeCircle(String moves) {
        int ud = 0;
        int lr = 0;
        
        for(int i=0;i<moves.length();i++) {
            if(moves.charAt(i) == 'L') {
               lr++;
            }
            
            if(moves.charAt(i) == 'R') {
               lr--;
            }
                
            if(moves.charAt(i) == 'U') {
               ud++;
            }
            
            if(moves.charAt(i) == 'D') {
               ud--;
            }
        }
        
        return lr == 0 && ud == 0;
    }
}