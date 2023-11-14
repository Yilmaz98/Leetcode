class MovingAverage {
    Queue<Integer> q;
    int size_t;
    int sum;
    
    public MovingAverage(int size) {
        q = new LinkedList<>();
        size_t = size;
        sum = 0;
    }
    
    public double next(int val) {
        sum += val;
        q.add(val);
        
        if(q.size() > size_t) {
            int v = q.poll();
            sum -= v;
        }
        
        return (double) sum / Math.min(q.size(), size_t);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */