class Solution {
    public double myPow(double x, int n) {
     return myPow1(x, (long) n);
    }
    
    public double myPow1(double x, long n) {
           if(n < 0) {
            x = (double) 1/x;
            n = -n;
        }
        
        if(n == 0)
            return 1;
        
        if(n == 1)
            return x;
        
        if(n%2 == 1)
            return x * myPow1(x * x, (n-1)/2);
        else 
            return myPow1(x * x, n/2);
    }
}