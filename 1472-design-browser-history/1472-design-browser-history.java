class BrowserHistory {
    int index = 0;
    List<String> arr = new ArrayList<>();

    public BrowserHistory(String homepage) {
        arr.add(homepage);
    }
    
    public void visit(String url) {
        if(index + 1 < arr.size()) {
            arr = arr.subList(0,index+1);
        }
        
        index++;
        arr.add(url);
    }
    
    public String back(int steps) {
        int idx = Math.max(0,index - steps);
        index = idx;
        return arr.get(idx);
    }
    
    public String forward(int steps) {
        int idx = Math.min(arr.size()-1, index+steps);
        index = idx;
        return arr.get(idx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */