class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        int count = 0;
        Set<String> start = new HashSet<>();
        
        for(String s: startWords) {
            char[] curr = s.toCharArray();
            Arrays.sort(curr);
            start.add(new String(curr));
        }
        
        for(String s : targetWords) {
            char[] curr = s.toCharArray();
            Arrays.sort(curr);
            String ns = new String(curr);
            for(int i=0;i<ns.length();i++) {
                String subString = ns.substring(0,i) + ns.substring(i+1,s.length());
                if(start.contains(subString)) {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}