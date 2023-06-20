class Solution {
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        
        for(int i=0;i<s.length();i++) {
            count[s.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<order.length();i++) {
            if(count[order.charAt(i) - 'a'] > 0) {
                while(count[order.charAt(i) - 'a'] > 0) {
                    sb.append(order.charAt(i));
                    count[order.charAt(i) - 'a']--;
                }
            }
        }
        
        for(int i=0;i<s.length();i++) {
            if(count[s.charAt(i) - 'a'] > 0) {
                while(count[s.charAt(i) - 'a'] > 0) {
                    sb.append(s.charAt(i));
                    count[s.charAt(i) - 'a']--;
                }
            }
        }
        
        return sb.toString();
    }
}