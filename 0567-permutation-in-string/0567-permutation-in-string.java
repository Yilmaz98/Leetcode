class Solution {
    public boolean checkInclusion(String s1, String s2) {
        String sortedS1= sort(s1);
        
        for(int i=0;i<=s2.length() - s1.length();i++) {
            String sortedS2 = sort(s2.substring(i, i+ s1.length()));
           if(sortedS1.equals(sortedS2))
               return true;
        }
        
        return false;
    }
    
    public String sort(String s) {
        char[] s1String = s.toCharArray();
        Arrays.sort(s1String);
        return new String(s1String);
    }
}