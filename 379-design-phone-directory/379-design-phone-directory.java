class PhoneDirectory {
    Set<Integer> s;
    public PhoneDirectory(int maxNumbers) {
        s = new HashSet<>();
        
        int num = 0;
        while(maxNumbers-->0) {
            s.add(num++);
        }
    }
    
    public int get() {
        if(s.isEmpty())
            return -1;
        int val = s.iterator().next();
        s.remove(val);
        return val;
    }
    
    public boolean check(int number) {
        if(s.contains(number))
            return true;
        return false;
    }
    
    public void release(int number) {
        s.add(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */