class Solution {
    public int shortestWay(String source, String target) {
        int ans = 0;
        
        String remaining = target;   
        while(remaining.length() > 0) {

            int i = 0;
            int j = 0;    
            StringBuilder subsequence = new StringBuilder();
            while(i< source.length() && j<remaining.length()) {
                if(source.charAt(i++) == remaining.charAt(j))
                    subsequence.append(remaining.charAt(j++));
            }
            
            System.out.println(subsequence.toString());
            
            if(subsequence.length() == 0)
                return -1;
                
            ans++;
            remaining = remaining.substring(subsequence.length());
        }
        
        
        return ans;
    }
}