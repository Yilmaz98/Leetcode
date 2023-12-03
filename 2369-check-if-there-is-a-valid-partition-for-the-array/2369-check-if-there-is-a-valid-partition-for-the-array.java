class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return backtrack(nums, 0, n, dp) == 1? true : false;
    }
    
    public int backtrack(int[] nums, int idx, int n, int[] dp) {
        if(idx == n)
            return 1;
        
        if(dp[idx] != -1)
            return dp[idx];
        
        int len = 0;
        int prev = nums[idx];
        List<Integer> tempList = new ArrayList<>();
        int noConsecutive = 0;
        int noEqual = -1;
        for(int i=idx;i<Math.min(n, idx + 3);i++) {
            long diff = nums[i] - prev;
            if(diff == 1) {
                noConsecutive++;
            }
            if(diff == 0) {
                noEqual++;
            }
            tempList.add(nums[i]);
            if(diff !=0 && diff != 1) 
                return 0;
            len++;
            prev = nums[i];
            if(len == 2) {    
                if(noConsecutive == 0) {
                    if(backtrack(nums, i + 1, n, dp) == 1)
                        return dp[idx] = 1;
                }
            } 
            
            if(len == 3) {
                if(noEqual == 0 || noConsecutive == 0)
                    if(backtrack(nums, i + 1, n, dp) == 1)
                        return dp[idx] = 1;
            }
        }
        
        return dp[idx] = 0;
    }
}