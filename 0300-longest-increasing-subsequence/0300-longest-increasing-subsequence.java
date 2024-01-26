class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];

        for(int i = 0;i<n;i++) {
            hash[i] = i;
        }

        int lastIndex = 0;
        int maxi = 1;

        for(int i = 1;i<n;i++) {
            for(int prev = 0;prev<i;prev++) {
                if(nums[i] > nums[prev] && dp[i] < (1 + dp[prev])) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                    if(maxi < dp[i]) {
                        maxi = dp[i];
                        lastIndex = i;
                    }
                }
            }
        }

        List<Integer> arr = new ArrayList<>();

        while(hash[lastIndex] != lastIndex) {
            arr.add(nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }
        
        arr.add(nums[lastIndex]);

        Collections.reverse(arr);

        return maxi;
    }
}