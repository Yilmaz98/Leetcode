class Solution {
    public int[][] merge(int[][] intervals) {
        
    	Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
    	
    	List<int[]> res = new ArrayList<>();
    	
    	int[] r = new int[2];
    	r[0] = intervals[0][0];
    	r[1] = intervals[0][1];
    	for (int i=1; i<intervals.length; i++) {
    		if (intervals[i][0] <= r[1]) {
    			r[1] = Math.max(r[1], intervals[i][1]);
    		} else {
    			res.add(r);
    			r=new int[2];
    			r[0] = intervals[i][0];
    			r[1] = intervals[i][1];
    		}
    	}
    	
    	if (res.isEmpty() || r[0] != res.get(res.size()-1)[0]) {
    		res.add(r);
    	}
    	
    	
        return res.toArray(new int[res.size()][]);
    }
}