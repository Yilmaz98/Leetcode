class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int score = 0;
        int maxScore = 0;
        
        for(int i=0;i<k;i++) {
            score += cardPoints[i];
            maxScore = Math.max(maxScore, score);
        }
        
          if(k == cardPoints.length)
  {
      return score;
  }
        
        int n = cardPoints.length - 1;
        k = k-1;
        
        while(k+1>0) {
            score -=cardPoints[k--];
            score += cardPoints[n--];
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}