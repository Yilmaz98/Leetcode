class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        return backtrack(s, p, 0, 0, m, n);
    }
    
    public boolean backtrack(String s, String p, int i, int j, int m, int n) {
        if(i >= m && j >= n) {
            return true;
        }
        
        if(j>=n)
            return false;
        
        boolean isStar = false;
        
        boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j + 1 < n &&  p.charAt(j + 1) == '*')
            isStar = true;
        
        if(isStar) {
            if(backtrack(s,p,i,j+2,m,n) || match && backtrack(s,p,i+1,j,m,n))
                    return true;
        }
        
        if(match) {
            if(backtrack(s,p,i+1,j+1,m,n))
                return true;
        }
        
        return false;
    }
}