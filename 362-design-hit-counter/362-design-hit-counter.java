class HitCounter {    
    TreeMap<Integer, Integer> totalMap = new TreeMap<>();
    public HitCounter() {
        
    }
    
    public void hit(int timestamp) {
        Integer prevKey = totalMap.floorKey(timestamp);
        if(prevKey != null) {
            totalMap.put(timestamp, totalMap.get(prevKey)+1);
        } else {
           totalMap.put(timestamp, 1); 
        }
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