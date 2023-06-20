class Solution {
    public String addStrings(String num1, String num2) {        
        if(num1.length() > num2.length()) {
            return addStrings(num2,num1);
        }
        
        int m = num1.length();
        int n = num2.length();
        int j = m - 1;
        int i = n - 1;
        

        int carry = 0;
        
        StringBuilder sb = new StringBuilder();
        
        while(j >= 0) {
            int val1 = Integer.parseInt(String.valueOf(num1.charAt(j)));
            int val2 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            
            int sum = (val1 + val2 + carry);
            
            sb.append(sum % 10);
            
            carry = sum/10;
            
            j--;
            i--;
        }
        
        while(i >=0) {
            int val1 = Integer.parseInt(String.valueOf(num2.charAt(i)));
            int sum =  (val1 + carry);
            sb.append(sum % 10);
            carry = sum/10;
            i--;
        }
        
        if(carry > 0)
            sb.append(carry);
        
        return sb.reverse().toString();
    }
}