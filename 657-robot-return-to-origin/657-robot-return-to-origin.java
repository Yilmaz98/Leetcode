class Solution {
    public boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;
        
        for (char c : moves.toCharArray()) {
            
            switch (c) {
                case 'U': vertical++; break;
                case 'D': vertical--; break;
                case 'R': horizontal++; break;
                case 'L': horizontal--; break;
            }
        }
        
        return (horizontal == 0 && vertical == 0); 
    }
}