class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxScore = 0;
        int score = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<k;i++) {
            score += cardPoints[i];
            st.push(cardPoints[i]);
            maxScore = Math.max(maxScore, score);
        }
        
        int n = cardPoints.length -1;
        
        while(!st.isEmpty()) {
            score -= st.pop();
            score += cardPoints[n--];
            maxScore = Math.max(maxScore, score);
        }
        
        return maxScore;
    }
}