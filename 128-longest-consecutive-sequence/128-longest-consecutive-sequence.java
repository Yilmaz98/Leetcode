class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Arrays.sort(nums);
        
        int ans = 1;
        int maxAns = 1;
        for(int i=1;i<nums.length;i++) {
            if(nums[i] - nums[i-1] == 0) {
                continue;
            }
            if(nums[i] - nums[i-1] == 1) {
                ans++;
            } else {
                ans = 1;
            }
            
            maxAns = Math.max(maxAns,ans);
        }
        
        return maxAns;
    }
}