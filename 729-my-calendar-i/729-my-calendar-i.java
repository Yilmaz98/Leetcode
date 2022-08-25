class MyCalendar {
    TreeMap<Integer, Integer> m = new TreeMap<>();
    
    public MyCalendar() {

    }
    
    public boolean book(int start, int end) {
        m.put(start, m.getOrDefault(start,0) + 1);
        m.put(end, m.getOrDefault(end,0) - 1);
        
        int sum = 0;
        
        for(Integer i: m.keySet()) {
            sum += m.get(i);   
            if(sum > 1) {
                m.put(start,m.get(start)-1);
                if(m.get(start) == 0)
                    m.remove(start);
                m.put(end,m.get(end)+1);
                 if(m.get(end) == 0)
                    m.remove(end);
                return false; 
            }      
        }
        
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */