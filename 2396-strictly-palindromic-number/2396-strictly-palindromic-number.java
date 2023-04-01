class Solution {
    public boolean convertByBase(int n, int b) {
        StringBuilder sb = new StringBuilder();
        while(n!=0) {
            sb.append(n%b);
            n = n/b;
        }
        
        if(sb.toString() == sb.reverse().toString())
            return true;
        else 
            return false;
        
    }
    
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++) {
            if(!convertByBase(n,i)) {
                return false;
            } 
        }
        
        return true;
    }
}