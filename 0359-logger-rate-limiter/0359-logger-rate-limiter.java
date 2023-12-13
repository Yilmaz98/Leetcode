class Logger {
    Map<String, Integer> m;
    public Logger() {
        m = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(m.containsKey(message)) {
           if(timestamp < m.get(message)) {
               return false;
           }
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