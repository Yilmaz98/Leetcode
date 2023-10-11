class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        
        for(String word : strings) {
            char[] curr = word.toCharArray();
            StringBuilder key = new StringBuilder();
            
            for(int i=1;i<curr.length;i++) {
                int diff = curr[i] - curr[i-1];
                if(diff < 0)
                    diff = diff + 26;
                key.append(diff + ",");
            }
            
            if(!m.containsKey(key.toString()))
                m.put(key.toString(), new ArrayList<>());
            
            m.get(key.toString()).add(word);
        }
                
        return new ArrayList<>(m.values());
    }
}