class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int sum=0;
		int tmp=0;
		int count=Integer.MAX_VALUE;
		for (int i=0; i<arr.length; i++) {
			sum += arr[i];
			while(sum >= target) {
				count = Math.min(count, (i-tmp)+1);
				sum -= arr[tmp];
				tmp++;
			}
		}
		
		return count == Integer.MAX_VALUE ? 0 : count;
    }
}