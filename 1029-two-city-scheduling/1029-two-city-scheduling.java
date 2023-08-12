class Solution {
    public class CustomComparator implements Comparator<int[]> {
        public int compare(int[] a, int[] b) {
            return (a[0] - a[1]) - (b[0] - b[1]);
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new CustomComparator());
        
        int result = 0;
        int n = costs.length/2;
        
        for(int i=0;i<n;i++) {
            result += costs[i][0];
            result += costs[i+n][1];
        }
        
        return result;
    }
}