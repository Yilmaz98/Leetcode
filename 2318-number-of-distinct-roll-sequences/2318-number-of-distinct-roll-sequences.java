class Solution {
  int[][][] memo = new int[10001][7][7]; int mod = 1000000007;
int[][] m = {{1,2,3,4,5,6},
			 {2,3,4,5,6},
			 {1,3,5},
			 {1,2,4,5},{1,3,5},
			 {1,2,3,4,6},
			 {1,5}};
public int distinctSequences(int n) {
	return dp(n, 0, 0);
}
private int dp(int n, int prev, int pprev) {
	if (n == 0) return 1;
	if (memo[n][prev][pprev] != 0) return memo[n][prev][pprev];
	int ans = 0;
	for (int x: m[prev])
		if (x != pprev) ans = (ans + dp(n - 1, x, prev)) % mod;
	return memo[n][prev][pprev] = ans;
}
}