class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<String, Integer> map = new HashMap<>();
        return solve(triangle, 0, 0, map);
    }
    
    public int solve(List<List<Integer>> triangle, int row, int index, Map<String, Integer> map) {
        String key = row + "-" + index;
        
        if (map.get(key) != null) {
            return map.get(key);
        }
        
        if (index >= triangle.get(row).size()) {
            return 0x7FFFFFFF;
        }
        
        if (row == triangle.size() - 1) {
            return  triangle.get(row).get(index);
        }
        
        
        int below = solve(triangle, row + 1, index, map);
        int right = solve(triangle, row + 1, index + 1, map);
        int result = Math.min(below, right) + triangle.get(row).get(index);
        
        map.put(key, result);
        
        return result;
        
    }
}