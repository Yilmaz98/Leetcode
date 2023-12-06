class Solution {
    public int longestRepeatingSubstring(String s) {
        int low = 0;
        int high = s.length() - 1;
        int ans = 0;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(checkRepeatingString(s, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    public boolean checkRepeatingString(String s, int len) {
        Set<Integer> seen = new HashSet<>();
        int hashCode = 0;
        for(int i=0;i<s.length() - len + 1;i++) {
            String substr = s.substring(i, i + len);
            hashCode = substr.hashCode();
            if(seen.contains(hashCode)) {
                return true;
            }
            seen.add(hashCode);
        }
        
        return false;
    }

}