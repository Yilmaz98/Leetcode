class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int mod = (int)(1e9 + 7);
    public int numTilings(int n) {
        if(n <= 2) {
            return n;
        }
        if(n == 3) {
            return 5;
        }
        if(map.containsKey(n)) return map.get(n);
        int res = (2 * numTilings(n-1) % mod + numTilings(n-3) % mod) % mod;
        map.put(n, res);
        return res;
    }
}