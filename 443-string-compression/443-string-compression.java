class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int f = 0;
        
        while(index < chars.length) {
            int count = 0;
            char currentChar = chars[index];
            
            while(index < chars.length && chars[index] == currentChar) {
                index++;
                count++;
            }
            
            chars[f++] = currentChar;
            
            String split = String.valueOf(count);
            char[] all = split.toCharArray();
            
            if(count!=1)
                for(char c : all) {
                    chars[f++] = c;
                }
            
        }
        
        return f;
    }
}