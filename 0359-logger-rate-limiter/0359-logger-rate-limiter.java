class Logger {
    Map<String, Integer> times;
    
    public Logger() {
        times = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(times.containsKey(message)) {
            if(timestamp < times.get(message))
                return false;
        }
        
        times.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */