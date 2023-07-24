class Solution {
    public class ArrayComparator implements Comparator<int[]> {
        public int compare(int[] a, int [] b){
            return (a[0] - a[1]) - (b[0] - b[1]);
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new ArrayComparator());
        
        int ans = 0;
        int n = costs.length/2;
        
        for(int i=0;i<n;i++) {
            ans += costs[i][0] + costs[i+n][1];
        }
        
        return ans;
    }
}