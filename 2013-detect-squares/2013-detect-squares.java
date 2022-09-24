class DetectSquares {
    int[][] count = new int[1001][1001];
    List<int[]> points = new ArrayList<>();
    
    
    public DetectSquares() {
        
    }
    
    public void add(int[] point) {
        count[point[0]][point[1]]++;
        points.add(point);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int ans = 0;
        
        for(int[] p : points) {
            int x3 = p[0];
            int y3 = p[1];
            
            if(Math.abs(x1 - x3) == 0 || Math.abs(x1 - x3) != Math.abs(y1-y3))
                continue;
            
            ans += count[x1][y3] * count[x3][y1]; 
        }
        
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */