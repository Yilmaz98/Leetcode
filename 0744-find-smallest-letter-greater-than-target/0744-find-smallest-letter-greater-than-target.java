class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<letters.length;i++) {
            if(letters[i] - target <= 0)
                continue;
             min = Math.min(min, letters[i] - target);
 
                
        }
        
        return min == Integer.MAX_VALUE ? letters[0] : (char) (min + target);
    }
}