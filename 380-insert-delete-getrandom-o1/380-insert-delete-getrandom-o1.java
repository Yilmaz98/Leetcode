class RandomizedSet {
    Set<Integer> s;
    List<Integer> l;
    Random rand = new Random();
    
    public RandomizedSet() {
        s = new HashSet<>();
        l = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(s.contains(val))
            return false;
        s.add(val);
        l.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(s.contains(val))
        {
            s.remove(val);
            l.remove(l.indexOf(val));
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        int n = rand.nextInt(l.size());
        return l.get(n);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */