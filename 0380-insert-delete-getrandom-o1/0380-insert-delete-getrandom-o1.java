class RandomizedSet {
    Set<Integer> s = new HashSet<>();
    public RandomizedSet() {
        
    }
    
    public boolean insert(int val) {
        if(s.contains(val))
            return false;
        
        s.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(s.contains(val)){
            s.remove(val);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        Random r = new Random();
        int curr = r.nextInt(s.size());
        int i =0;
        for(Integer a : s) {
            if(i == curr)
                return a;
            i++;
        }
        return -1;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */