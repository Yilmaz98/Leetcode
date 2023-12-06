class Solution {
    public int longestRepeatingSubstring(String s) {
        Set<String> seen = new HashSet<>();
        
        int n = s.length();
        int maxLen = 0;
        
        for(int i=0;i<n;i++) {
            for(int j = i + 1;j<n;j++) {
                String substr = s.substring(i, j + 1);
                if(seen.contains(substr)) {
                    maxLen = Math.max(maxLen, substr.length());
                }
                seen.add(substr);
            }
        }
        
        return maxLen;
    }
}