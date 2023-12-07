class Pair {
    String message;
    int timestamp;
    
    Pair(String message, int timestamp) {
        this.message = message;
        this.timestamp = timestamp;
    }
};

class Logger {
    Queue<Pair> q;
    Set<String> present;
    int firstTime; 
    String firstMessage;
    
    public Logger() {
        q = new LinkedList<>();
        present = new HashSet<>();
        firstTime = 0;
        firstMessage = new String();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {        
        while(!q.isEmpty()) {
            firstTime = q.peek().timestamp;
            firstMessage = q.peek().message;
            if(timestamp >= firstTime + 10) {
                q.poll();
                present.remove(firstMessage);
            } else 
                break;
        }
        
        if(present.contains(message))
            return false;
        
        q.add(new Pair(message, timestamp));
        present.add(message);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */