class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hsm = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        
        for (String s : strs) {
        	char[] charKey = s.toCharArray();
        	Arrays.sort(charKey);
        	String key = new String(charKey);
        	if (!hsm.containsKey(key)) hsm.put(key, new ArrayList<>());
        	hsm.get(key).add(s);
        }
        
        return new ArrayList<>(hsm.values());
    }
}