class Logger {
    Map<String, Integer> timer;
    
    public Logger() {
        timer = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timer.containsKey(message)) {
            if(timestamp >= timer.get(message)) {
                timer.put(message, timestamp + 10);
                return true;
            } else
                return false;
        }
        
        timer.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */