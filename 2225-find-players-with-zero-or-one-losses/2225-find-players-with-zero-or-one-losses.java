class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
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
        
        result.get(0).addAll(noMatch);
        Collections.sort(result.get(0));
        
        result.get(1).addAll(oneMatch);
        Collections.sort(result.get(1));
        
        return result;
    }
}