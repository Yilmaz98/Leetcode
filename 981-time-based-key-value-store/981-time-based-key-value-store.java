class TimeMap {
    Map<String, TreeMap<Integer, String>> dataStore = new HashMap<>();
    
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!dataStore.containsKey(key))
            dataStore.put(key, new TreeMap<>());
        
        TreeMap<Integer, String> time = dataStore.get(key);
        time.put(timestamp, value);
        
        dataStore.put(key, time);
    }
    
    public String get(String key, int timestamp) {
        if(!dataStore.containsKey(key))
            return "";
        
        TreeMap<Integer,String> time = dataStore.get(key);
        if(time.containsKey(timestamp))
            return time.get(timestamp);
        
        Integer fKey = time.floorKey(timestamp);
        
        return fKey!=null? time.get(fKey) : "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */