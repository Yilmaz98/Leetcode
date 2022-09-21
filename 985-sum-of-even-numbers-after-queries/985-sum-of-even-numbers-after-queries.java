class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        
        for(int num : nums) {
           evenSum += ( (num%2==0)  ? num : 0);
        }
        
        int[] ans = new int[nums.length];
        int k =0;
        for(int[] query: queries) {
            int idx = query[1];
            
            if(nums[idx] % 2 == 0) {
               evenSum -= nums[idx]; 
            }
            
            nums[idx] += query[0];
            
            if(nums[idx] %2 == 0)
                evenSum +=  nums[idx] ;
                
            
            ans[k++] = evenSum;
        }
        
        return ans;
    }
}