class Solution {
    public int minSteps(int n) {
        int[][] memo = new int[n+1][n+1];
        helper(n,0, 1,0,memo);
        return memo[1][1];
    }
    
    public int helper(int n, int clipboard, int doc, int i, int[][] memo) {
        if(doc == n) {
            return memo[clipboard][doc] = i;
        }
        
        if(doc > n || clipboard > n) {
            return Integer.MAX_VALUE;
        }
        
        
        if(memo[clipboard][doc] != 0)
            return  memo[clipboard][doc];
        
        int copy = Integer.MAX_VALUE;
        int paste = Integer.MAX_VALUE;
        
        if(clipboard != doc)
            copy = helper(n,doc, doc,i+1,memo);
    
        if(clipboard > 0)
            paste = helper(n, clipboard, doc + clipboard,i+1, memo);
  
        return memo[clipboard][doc] = Math.min(copy,paste); 
    }
}