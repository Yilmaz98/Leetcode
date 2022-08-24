class Solution {
    public int smallestRangeII(int[] A, int K) {
            int N = A.length;
        Arrays.sort(A);
        int ans = A[N-1] - A[0];
        
        int highBound = A[N-1] - K;
        int lowBound = A[0] + K;

        for (int i = 0; i < A.length - 1; ++i) {
            int a = A[i], b = A[i+1];
            int high = Math.max(highBound, a + K);
            int low = Math.min(lowBound, b - K);
            ans = Math.min(ans, high - low);
        }
        return ans;
    }
}