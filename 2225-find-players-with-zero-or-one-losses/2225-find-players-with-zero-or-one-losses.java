class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int[] match : matches) {
            m.put(match[1],m.getOrDefault(match[1],0)+1);
        }
        
        Set<Integer> noMatch = new HashSet<>();
        Set<Integer> oneMatch = new HashSet<>();
        
        for(int[] match : matches) {
            if(!m.containsKey(match[0])) {
                noMatch.add(match[0]);
            } 
            
            if(m.get(match[1]) == 1) {
                oneMatch.add(match[1]);
            }
        }
        
        List<Integer> result0 = new ArrayList<>();
        result0.addAll(noMatch);
        Collections.sort(result0);
        
        List<Integer> result1 = new ArrayList<>();
        result1.addAll(oneMatch);
        Collections.sort(result1);
        
        result.add(result0);
        result.add(result1);
        
        return result;
    }
}