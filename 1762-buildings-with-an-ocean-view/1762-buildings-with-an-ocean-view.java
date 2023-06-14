class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();
        int n = heights.length;
        int prev = heights[n-1];
        result.add(n-1);
        
        for(int i=n-2;i>=0;i--) {
            if(heights[i] > prev) {
                result.add(0, i);
                prev = heights[i];
            }
        }
        
        int[] ans = new int[result.size()];
        
        for(int i=0;i<result.size();i++) {
            ans[i] = result.get(i);
        }
        
        return ans;
    }
}