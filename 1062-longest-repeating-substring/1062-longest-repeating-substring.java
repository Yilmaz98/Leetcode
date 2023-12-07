class Solution {
    public boolean checkString(String s, int mid) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        
        for(int i=0;i <= n - mid;i++)  {
            String substr = s.substring(i, i + mid);
            if(seen.contains(substr)) {
               return true; 
            }
            seen.add(substr);
        }   
        
        return false;
    }
    
    public int longestRepeatingSubstring(String s) {
        int n = s.length();
        int low = 0;
        int high = n -1;
        int ans = 0;
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            
            if(checkString(s, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
}