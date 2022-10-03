class BrowserHistory {
    List<String> visits;
    int size;
    int cur;
    public BrowserHistory(String homepage) {
        visits = new ArrayList<>();
        visits.add(homepage);
        size = 1;
        cur = 0;
    }
    
    public void visit(String url) {
        if (cur+1 < visits.size()) {
            visits.set(cur+1, url);
        } else {
            visits.add(url);
        }
        cur++;
        size = cur+1;
    }
    
    public String back(int steps) {
        int index = Math.max(0, cur-steps);
        cur = index;
        return visits.get(cur);
    }
    
    public String forward(int steps) {
        int index = Math.min(size-1, cur+steps);
        cur = index;
        return visits.get(cur);
    }
}