class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(s, result, new ArrayList<>(), 0);
        return result;
    }
    
    public void partition(String s, List<List<String>> result, List<String> temp, int idx) {
        if(idx == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=idx;i<s.length();i++) {
            if(isPalindrome(s.substring(idx,i+1))) {
                temp.add(s.substring(idx,i+1));
                partition(s, result, temp, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() -1;
                
        while(low <= high) {
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        
        return true;
    }
}