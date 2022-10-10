class Solution {
    private int comparePoints(int[] point1, int[] point2) {
        double dist1 = Math.sqrt(point1[0] * point1[0] + point1[1] * point1[1]);
        double dist2 = Math.sqrt(point2[0] * point2[0] + point2[1] * point2[1]);
        return Double.compare(dist1, dist2);
    }
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> comparePoints(a,b));
        for(int i=0;i<points.length;i++) {
            pq.add(new int[]{points[i][0], points[i][1]});
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while(i<k) {
            ans[i][0] = pq.peek()[0];
            ans[i][1] = pq.peek()[1];
            pq.poll();
            i++;
        }
        
        return ans;
    }
}