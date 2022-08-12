class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            char[] curr = strs[i].toCharArray();
            Arrays.sort(curr);
            String joint = new String(curr);
            if(!m.containsKey(joint)){
                m.put(joint, new ArrayList<>());
            } 
             m.get(joint).add(strs[i]);
        }
        
        List<List<String>> result = new ArrayList<>();
        for(String s: m.keySet()) {
            result.add(m.get(s));
        }
        
        return result;
    }
}