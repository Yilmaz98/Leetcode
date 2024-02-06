class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int halfLen = (intLength + 1) / 2;
        int start = (int) Math.pow(10, halfLen - 1);
        int end = (int) Math.pow(10, halfLen) - 1;
        
        long[] result = new long[queries.length];
        int idx = 0;
        
        for(int query : queries) {
            if(query <= end - start + 1) {
                String firstHalf = String.valueOf(start + query - 1);
                String secondHalf = new StringBuilder(firstHalf).reverse().substring(intLength % 2);
                result[idx++] = Long.parseLong(firstHalf + secondHalf);
            } else {
                result[idx++] = -1;
            }
        }
        
        return result;
    }
}