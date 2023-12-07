class Logger {
    Map<String, Integer> oldMap;
    Map<String, Integer> newMap;
    int timeNew;
    
    public Logger() {
        oldMap = new HashMap<>();
        newMap = new HashMap<>();
        timeNew = 0;
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp >= timeNew + 20) {
            oldMap.clear();
            newMap.clear();
            timeNew = timestamp;
        } else if(timestamp >= timeNew + 10) {
            oldMap = Map.copyOf(newMap);
            newMap.clear();
            timeNew = timestamp;
        }
        
        if(newMap.containsKey(message)) {
            return false;
        }
        
        if(oldMap.containsKey(message) && oldMap.get(message) > timestamp - 10) {
            return false;
        }
        
        newMap.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */