class Solution {
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[][] memo = new int[n][n];
        int[][] maxx = new int[n][n];
        
        for(int i=0;i<n;i++) {
            maxx[i][i] = arr[i]; 
            for(int j=i+1;j<n;j++) {
                maxx[i][j] = Math.max(maxx[i][j-1], arr[j]);
            }
        }
        
           for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
               System.out.print(maxx[i][j] + " ");
            }
             
            System.out.println();
        }
        
        
        int ans= helper(memo,maxx, arr,0,arr.length-1);
        
         for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
               System.out.print(memo[i][j] + " ");
            }
             
            System.out.println();
        }
        
        return ans;
    
    }
    
    public int helper(int[][] memo, int[][] maxx, int[] arr, int start, int end) {
        if(start >= end)
            return 0;
        
        if(memo[start][end] != 0)
            return memo[start][end];
        
        int result = Integer.MAX_VALUE;
        for(int i= start;i<end;i++) {
            result = Math.min(result, helper(memo, maxx, arr,start,i) + helper(memo,maxx,arr,i+1,end) + (maxx[start][i] * maxx[i+1][end]));
        }
        
        return memo[start][end] = result;
    }
    
}