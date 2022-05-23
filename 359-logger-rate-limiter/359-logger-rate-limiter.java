class Logger {
    Map<String,Integer> m = new HashMap<>();
    public Logger() {
        
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp < m.getOrDefault(message,0)) {
            return false;
        }
        m.put(message, timestamp + 10);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */