class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i+1];
            
            if(next.length() < curr.length() && curr.startsWith(next)) return false;
            
            int minLength = Math.min(next.length(), curr.length());
            
            for (int j = 0; j < minLength; j++) {
               if(curr.charAt(j) != next.charAt(j)) {
                   if(orderMap[curr.charAt(j) -'a'] > orderMap[next.charAt(j) -'a'])
                       return false;
                   
                   break;
               }
            }
        }

        return true;
    }
}