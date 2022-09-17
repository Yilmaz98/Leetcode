class Solution {
    public boolean confusingNumber(int n) {
        Map<Character,Character> m = new HashMap<>();
        m.put('1','1');
        m.put('6','9');
        m.put('9','6');
        m.put('8','8');
        m.put('0','0');
        
        int count = 0;
        boolean isConfusing = true;
        String curr;
        StringBuilder reverse = new StringBuilder();
        curr = String.valueOf(n);
        for(char j : curr.toCharArray()) {
            if(!m.containsKey(j)) {
                return false;
            }
            reverse.append(m.get(j));
        }
            
            
        reverse.reverse();
            
        if(!curr.equals(reverse.toString())) {
                return true;
        }
        return false;
    }
}