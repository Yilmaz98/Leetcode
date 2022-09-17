class Solution {
    public boolean find_rec(long n1, long n2, String s, boolean found) {
        if(s.length() == 0 && found)
            return true;
        
        String sum = String.valueOf(n1 + n2);
        System.out.println(sum);
        if(s.length() < sum.length()  || !s.substring(0,sum.length()).equals(sum))
            return false;
        else {
            found = find_rec(n2, Long.parseLong(sum), s.substring(sum.length()), true);
        }
        
        return found;
    }
    
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        boolean found  = false;
        
        for(int i=1;i<n-1;i++){
            long n1 = Long.parseLong(num.substring(0,i));
            if(!String.valueOf(n1).equals(num.substring(0,i))) {
                break;
            }           
            for(int j = i + 1; j < n ; j++) {
                long n2 = Long.parseLong(num.substring(i,j));
                if(!String.valueOf(n2).equals(num.substring(i,j))) {
                    break;
                }
               found = find_rec(n1,n2,num.substring(j), false);
                if(found)
                    return true;
            }
        }
        
        return false;
    }
}