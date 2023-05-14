class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s,0);
        return result;
    }
    
    public void backtrack(List<List<String>> res, List<String> tempList, String s, int start)       {   
         if (start >= s.length()) res.add(new ArrayList<String>(tempList));
        for(int i=start;i<s.length();i++) {
            if(isPalindrome(s,start,i)) {
                tempList.add(s.substring(start, i+1));
                backtrack(res,tempList,s,i+1);
                tempList.remove(tempList.size()-1);
            }
        }
      }
    
    public boolean isPalindrome(String s, int low,int high) {
        while(low<high) {
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}