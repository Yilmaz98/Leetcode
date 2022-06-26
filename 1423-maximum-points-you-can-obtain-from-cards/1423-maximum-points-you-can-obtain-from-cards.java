class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, totalSum = 0, minSubarray = Integer.MAX_VALUE;
        int currSum = 0;
        int start = 0;
        
	for (int i=0; i<n; i++) {
		totalSum += cardPoints[i];
		currSum += cardPoints[i];
		if (i - start + 1 == (n-k)) 
            {
            minSubarray = Math.min(minSubarray, currSum);
			currSum -= cardPoints[i-(n-k)+1];
            start++;
		}
	}
        
        if(n-k == 0)
            return totalSum;

	return totalSum - minSubarray;
    }
}