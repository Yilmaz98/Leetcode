class Solution {
      public int numDecodings(String s) {
        HashMap<String, Integer> cache = new HashMap<>();
        return numDecodingsHelper(s, cache);
        }
    
    public int numDecodingsHelper(String s, HashMap<String, Integer> cache){
        if(cache.containsKey(s)) return cache.get(s);
        if(s==null || s.length()==0) return 1;
        int count = 0;
        for(int i=1;i<=s.length();i++){
            String temp = s.substring(0,i);
            if(temp.charAt(0)!='0' && Double.parseDouble(temp) >= 1 && Double.parseDouble(temp)<= 26){
                count += numDecodingsHelper(s.substring(i), cache);
            }
        }
        cache.put(s,count);
        return count;
        }
}