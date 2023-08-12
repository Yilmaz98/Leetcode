class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b) -> (a[0]-a[1]) - (b[0]-b[1]));
        
        int result = 0;
        int n = costs.length/2;
        
        for(int i=0;i<n;i++) {
            result += costs[i][0];
            result += costs[i+n][1];
        }
        
        return result;
    }
}