class HitCounter {    
    TreeMap<Integer, Integer> totalMap = new TreeMap<>();
    int count = 1;
    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        totalMap.put(timestamp, count++);
    }
    
    public int getHits(int timestamp) {
        System.out.println(totalMap);
        
        int bound = timestamp - 300;
        Integer prevKey = totalMap.floorKey(timestamp);
        if(prevKey == null)
            return 0;
        if(bound <= 0) {
            return totalMap.get(prevKey);
        }
        Integer nextKey = totalMap.floorKey(bound);
        if(nextKey!=null)
            return totalMap.get(prevKey) - totalMap.get(nextKey);
        else 
            return totalMap.get(prevKey);
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */