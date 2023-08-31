class Solution {
    public int compress(char[] chars) {
        int count = 1;
        
        StringBuilder sb = new StringBuilder();
        int n = chars.length - 1;
        
        if(chars.length == 0)
            return 0;
        int idx = 0;
        
        for(int i=0;i<chars.length-1;i++) {
            if(chars[i] == chars[i+1]) {
                count++;
            } else {
                chars[idx++] = chars[i];
                if(count == 1)
                    continue;
                
                List<Character> temp = new ArrayList<>();
                
                while(count != 0) {
                  temp.add(Character.forDigit(count %10,10));
                  count /= 10;
                }
                
                for(int j = temp.size() -1;j>=0;j--) {
                    chars[idx++] = temp.get(j);
                }
                
                count = 1;
            }
        }
        
        chars[idx++] = chars[n];
        if(count != 1) {
               List<Character> temp = new ArrayList<>();
                
                while(count != 0) {
                  temp.add(Character.forDigit(count %10, 10));
                  count /= 10;
                }
                
                for(int j = temp.size() -1;j>=0;j--) {
                    chars[idx++] = temp.get(j);
                }
        }

        return idx;
    }
}