class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n + 1];  
        dp[n] = 1;
        
        for(int i = n;i>=0;i--) {
            for(int j=0;j<wordDict.size();j++) {
                int end = wordDict.get(j).length();
                if(i + end <= n) {
                    if(s.substring(i, i + end).equals(wordDict.get(j))) {
                        if(dp[i + end] == 1)
                            dp[i] = 1;
                        }
                }
            }
        }
        
        return dp[0] == 1 ? true : false;
    }
}