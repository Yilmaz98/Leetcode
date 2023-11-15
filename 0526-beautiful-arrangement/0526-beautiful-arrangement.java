class Solution {
    int count = 0;
    public int countArrangement(int n) {
        backtrack(n, 0, new HashSet<>());
        return count;
    }
    
    
    public void backtrack(int n, int index, Set<Integer> s) {
        if(index == n) {
            count++;
        }
        
        for(int i=1;i<=n;i++) {
            if(s.contains(i))
                continue;
            if(i % (index+1) != 0 && (index+1) % i != 0)
                continue;
            s.add(i);
            backtrack(n, index+1, s);
            s.remove(i);
        }
    }
}