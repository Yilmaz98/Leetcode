class Solution {
    public String getHashCode(String s) {
        StringBuilder sb  = new StringBuilder();
        
        for(int i=1;i<s.length();i++) {
            char c = (char) ((s.charAt(i) - s.charAt(i-1) + 26) % 26 + 'a');
            sb.append(c);
        }    
        
        return sb.toString();
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for(String str : strings) {
            String hashCode = getHashCode(str);
            if(!groups.containsKey(hashCode)) {
                groups.put(hashCode, new ArrayList<>());
            }
            
            groups.get(hashCode).add(str);
        }
        
        return new ArrayList<>(groups.values());
    }
}