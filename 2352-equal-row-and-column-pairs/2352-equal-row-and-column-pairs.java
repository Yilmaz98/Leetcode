class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> m  = new HashMap<>();
        
        int n = grid.length;
        
        for(int i=0;i<n;i++) {
            String row = Arrays.toString(grid[i]);
            m.put(row, m.getOrDefault(row,0) + 1);
        }
        
        int ans = 0;
        for(int j=0;j<n;j++) {
            int[] col = new int[n];
            for(int i=0;i<n;i++) {
                col[i] = grid[i][j];
            }
            
            String cols = Arrays.toString(col);
            
            if(m.containsKey(cols))
                ans += m.get(cols);
        }
        
        return ans;
    }
}