class Solution {
    public boolean isPowerOfThree(int n) {
        double ans = Math.log10(n)/Math.log10(3);
        return ans % 1 == 0;
    }
}