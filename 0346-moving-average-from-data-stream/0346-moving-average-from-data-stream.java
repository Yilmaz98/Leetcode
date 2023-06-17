class MovingAverage {
    
    Queue<Integer> q = new LinkedList<>();
    double sum = 0.0;
    int count = 0;
    
    public MovingAverage(int size) {
           count = size; 
    }
    
    public double next(int val) {
        q.add(val);
        if(q.size() > count) {
            sum -= q.poll();
        }
        sum += val;
        
        return sum / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */