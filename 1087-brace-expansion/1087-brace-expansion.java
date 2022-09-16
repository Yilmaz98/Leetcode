class Solution {
    public String[] expand(String s) {
        List<String> result = new ArrayList<>();
        recurse(s,0,"",result); 
        Collections.sort(result);
        return result.toArray(String[] :: new);
    }
    
    public void recurse(String s, int start, String cur , List<String> res)
    {
        if (start == s.length()) {
            res.add(cur);
            return;
        }
        
        int left = s.indexOf('{',start);
        int right = s.indexOf('}',start);
        
        if(left == -1) {
            res.add(cur + s.substring(start));
            return;
        }
        
        
        String sub = s.substring(left+1,right);
        String str[] = sub.split(",");
        
        for(String st : str) {
            recurse(s, right + 1, cur + s.substring(start, left) + st, res);
        }
    }
    
}