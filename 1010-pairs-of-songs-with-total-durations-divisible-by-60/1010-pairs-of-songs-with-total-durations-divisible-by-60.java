class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        int ans = 0;
        for(int t : time) {
            int r = t % 60;
            ans = ans + arr[(60 - r) % 60];
            arr[r]++;
        }
        return ans;
    }
}