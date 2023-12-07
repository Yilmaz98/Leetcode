class Solution {
    public boolean checkForTwo(Set<Integer> row) {
        if(row.size() == 2 && row.contains(1) && row.contains(10))
            return true;    
        else if(row.size() == 1) {
            if(row.contains(1) || row.contains(10))
                return true;
        } 
        return false;
    }
    
    
    public boolean checkForOne(Set<Integer> row) {
        if(!row.contains(2) && !row.contains(3) && !row.contains(4) && !row.contains(5))
            return true;
        
          if(!row.contains(4) && !row.contains(5) && !row.contains(6) && !row.contains(7))
            return true;
        
          if(!row.contains(6) && !row.contains(7) && !row.contains(8) && !row.contains(9))
            return true;
        
        return false;
    }
    
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> m = new HashMap<>();
        
        for(int[] seat : reservedSeats) {
            if(!m.containsKey(seat[0]))
                m.put(seat[0], new HashSet<>());
            m.get(seat[0]).add(seat[1]);
        }
        
        int count = 0;
        for(Integer row : m.keySet()) {
            if(checkForTwo(m.get(row))) {
                count += 2;
            } else if(checkForOne(m.get(row))) {
                count += 1;
            } 
        }
        
        return 2 * (n - m.size()) +  count;
    }
}