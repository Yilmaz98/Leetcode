class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0]==b[0] ? b[1] - a[1]: a[0] - b[0] );
        
    	List<int[]> res = new ArrayList<>();
        
    	for (int[] first : firstList) {
    		pq.add(new int[] {first[0], 1});
    		pq.add(new int[] {first[1], -1});
    	}
        
    	for (int[] second : secondList) {
    		pq.add(new int[] {second[0], 1});
    		pq.add(new int[] {second[1], -1});
    	}
    	
    	int sum = 0;
        int[] pqVal;
        
    	while(!pq.isEmpty()) {
    		pqVal = pq.poll();
    		sum += pqVal[1];
    		if (sum >= 2) {
    			res.add(new int[]{pqVal[0], pq.peek()[0]});
    		}
    	}
    	
    	int[][] resVal = new int[res.size()][2];
        
    	for (int i=0; i<res.size(); i++) {
    		resVal[i] = res.get(i);
    	}
    	
    	return resVal;
    }
}