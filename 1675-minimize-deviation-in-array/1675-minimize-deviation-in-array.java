class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int minimumEven = Integer.MAX_VALUE;
        
        for(int i: nums) {
            if(i%2 == 0) {
                pq.add(i);
                minimumEven = Math.min(minimumEven, i); 
            }
            else {
                pq.add(i*2);
                minimumEven = Math.min(minimumEven, i*2); 
            }
        }
        
        int minDeviation = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()) {
            int currentValue = pq.poll();
            minDeviation = Math.min(minDeviation, currentValue - minimumEven);
            if(currentValue % 2 == 0) {
                pq.add(currentValue/2);
                minimumEven =  Math.min(minimumEven, currentValue/2);
            }
            else 
                break;
            
        }
        
        return minDeviation;
    }
}