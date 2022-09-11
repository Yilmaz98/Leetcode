class Solution {
    public boolean judgeCircle(String moves) {
        int[] xdir = {-1,1,0,0};
        int[] ydir = {0,0,1,-1};
        
        int[] curr = new int[]{0,0};
        
        for(int i=0;i<moves.length();i++) {
            if(moves.charAt(i) == 'L') {
               
                curr[0] += xdir[0];
                curr[1] += ydir[0]; 
            }
            
            if(moves.charAt(i) == 'R') {
               curr[0] += xdir[1];
                curr[1] += ydir[1]; 
            }
                
            if(moves.charAt(i) == 'U') {
               curr[0] += xdir[2];
                curr[1] += ydir[2]; 
            }
            
            if(moves.charAt(i) == 'D') {
               curr[0] += xdir[3];
                curr[1] += ydir[3]; 
            }
        }
        
        return curr[0] == 0 && curr[1] == 0;
    }
}