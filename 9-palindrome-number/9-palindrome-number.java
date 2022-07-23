class Solution {
    public boolean isPalindrome(int x) {
        int temp = x;
        if(x<0){
            return false;
        }
        int ans = 0;
        
        while(x!=0) {
            ans = ans*10 + x%10;
            x = x/10;
        }
        
        System.out.println(ans);
        if(ans == temp)
            return true;
        else
            return false;
    }
}