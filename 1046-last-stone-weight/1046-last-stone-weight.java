class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for(int i=0;i<stones.length;i++) {
            pq.offer(stones[i]);
        }
        
        while(!pq.isEmpty()) {
            if(pq.size() == 1) {
                return pq.poll();
            }
            Integer a = pq.poll();
            Integer b = pq.poll();
            
            if(a!=b){
                pq.offer(a-b);
            } 
        }
        
        return 0;
    }
}