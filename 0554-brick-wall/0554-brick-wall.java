class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<wall.size();i++) {
            int sum = 0;
            for(int j=0;j<wall.get(i).size()-1;j++) {
                sum += wall.get(i).get(j);
                m.put(sum, m.getOrDefault(sum,0)+1);
            }
        }
        
        int max = 0;
        for(Integer i : m.keySet()) {
            max = Math.max(max, m.get(i));
        }
        
        return wall.size() - max;
        
        
    }
}