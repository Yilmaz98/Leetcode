class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> m = new HashMap<>();
        
        for(int[] point: points) {
            if(!m.containsKey(point[0])) {
                m.put(point[0], new HashSet<>());
            }
            
            m.get(point[0]).add(point[1]);
        }
        
        System.out.println(m);
        
        int minArea = Integer.MAX_VALUE;
        for(int[] p1: points) {
            for(int[] p2: points) {
                if(p1[0] == p2[0] || p1[1] == p2[1])
                    continue;
            if(m.get(p1[0]).contains(p2[1]) && m.get(p2[0]).contains(p1[1])) {
                minArea = Math.min(minArea, Math.abs(p1[0] -p2[0]) * Math.abs(p1[1]-p2[1]));
            }
                }
        }
        
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }
}