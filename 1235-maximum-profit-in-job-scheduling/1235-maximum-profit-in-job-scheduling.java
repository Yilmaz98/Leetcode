class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] arr = new int[startTime.length][3];
        
        for(int i=0;i<startTime.length;i++) {
            arr[i] = new int[]{startTime[i],endTime[i], profit[i]};
        }
        
        Arrays.sort(arr, (a,b) -> a[1] - b[1]);
                
        int[] dp = new int[startTime.length];
        
        for(int i=0;i<arr.length;i++) {
            dp[i] += arr[i][2];
            int max = 0;
            for(int j=i-1;j>=0;j--) {
                if(arr[j][1] <= arr[i][0]) {
                    dp[i] += dp[j];
                    break;
                }
            }
            
            int val = i==0 ? 0 : dp[i-1];
            dp[i] = Math.max(dp[i], val );
        }
        
        return dp[startTime.length - 1];
    }
}