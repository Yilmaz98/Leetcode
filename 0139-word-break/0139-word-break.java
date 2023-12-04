class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        
        return recurse(s, 0, wordDict, dp) == 1? true: false;
    }
    
    public int recurse(String s, int idx, List<String> wordDict, int[] dp) {
        if(idx >= s.length()) {
            return dp[idx] = 1;
        }
        
        if(dp[idx] != -1)
            return dp[idx];
        
        for(int i=0;i<wordDict.size();i++) {
            int end = wordDict.get(i).length();
            if(idx + end <= s.length()) {
                if(s.substring(idx, idx + end).equals(wordDict.get(i))) {
                if(recurse(s, idx + end, wordDict, dp) == 1)
                    return dp[idx] = 1;
                }
            }
        }
        
        return dp[idx] = 0;
    }
}