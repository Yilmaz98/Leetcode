class Solution {
    public long[] kthPalindrome(int[] queries, int l) {
         long[] res = new long[queries.length];
        int i = 0, half = (l + 1) / 2;
        long start = (long) Math.pow(10, half - 1), end = (long) Math.pow(10, half) - 1;
        for (int query : queries) {
            if (query <= end - start + 1) {
                String firstHalf = String.valueOf(start + query - 1);
                String secondHalf = (new StringBuilder(firstHalf)).reverse().toString();
                res[i++] = Long.parseLong(firstHalf + secondHalf.substring(l % 2));
            } else res[i++] = -1;
        }
        return res;
    }
}