class Solution {
    public int numTeams(int[] rating) {
        int ans = 0;
        for(int i=0;i<rating.length-1;i++) {
            int leftSmaller = 0, leftLarger = 0;
            int rightSmaller = 0, rightLarger = 0;
            
            for(int j = 0;j<i;j++) {
                if(rating[j] < rating[i]) {
                       leftLarger++;
                }
                if(rating[j]> rating[i]) {
                    leftSmaller++;
                }
            }
            
            for(int k = i+1;k<rating.length;k++) {
                if(rating[k] > rating[i]) {
                         rightSmaller++;
                 
                }
                
                if(rating[k] < rating[i]) {
                  rightLarger++;
                }
            }
            
            ans += (leftSmaller * rightLarger) + (leftLarger * rightSmaller);
        }
        
        return ans;
    }
}