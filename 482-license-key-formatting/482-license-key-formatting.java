class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String curr = s.replace("-","");
        String result = "";
        int dashes = 0;
        
        for(int i=curr.length()-1;i>=0;i--) {
            if(result.length() != 0 && (result.length()- dashes) %k == 0) {
               result+="-"; 
                dashes++;
            }
                
            result += (curr.charAt(i));
        }
        StringBuilder sb = new StringBuilder(result.toUpperCase());
        
        return sb.reverse().toString();
        
     }
}