class Solution {
    
    public boolean dfs(int[][] grid, int boy, int n, int[] girlMatch, Set<Integer> seen) {
            for(int j=0;j<n;j++) {
                if(grid[boy][j] == 0 || seen.contains(j)){
                    continue;
                }
                
                seen.add(j);
                if(girlMatch[j] == -1 || dfs(grid,girlMatch[j],n,girlMatch, seen)) {
                    girlMatch[j] = boy;
                    return true;
                }
            }
        return false;
    }
    
    public int maximumInvitations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] girlMatch = new int[n];
        Arrays.fill(girlMatch, -1);
                    
        int invitations = 0;
        
        Set<Integer> seen;
        for(int i=0;i<m;i++) {
            seen = new HashSet<>();
            if(dfs(grid,i,n,girlMatch, seen)) {
                invitations++;
            } 
        }        
        return invitations;
    }
}