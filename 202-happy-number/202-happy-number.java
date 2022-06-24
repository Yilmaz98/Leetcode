class Solution {
    
    public int getSumOfSquares(int n) {
        
        int sum = 0;
    while(n!=0)
        {  
        int r = n %10;
        sum += r*r;
        n = n/10;
        }
        
        return sum;
        
    }
    public boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while(!s.contains(n)) {
            s.add(n);
            n = getSumOfSquares(n);
        }
        
        return n==1;
    }
}