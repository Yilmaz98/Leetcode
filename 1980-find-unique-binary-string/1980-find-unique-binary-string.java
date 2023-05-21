class Solution {
    String ans;
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        Set<String> exist = new HashSet<>();
        
        for(int i=0;i<nums.length;i++) {
            exist.add(nums[i]);
        }
        
        backtrack(n, exist, new StringBuilder());
        
        return ans;
    }
    
    public void backtrack(int n, Set<String> exist, StringBuilder s) {
        if(s.length() > n)
            return;
        
        if(s.length() == n) {
            if(!exist.contains(s.toString())) {
                ans = s.toString();
                return;
            }
        }
        
        s.append("0");
        backtrack(n,exist,s);
        s.deleteCharAt(s.length()-1);
        s.append("1");
        backtrack(n,exist,s);
        s.deleteCharAt(s.length()-1);
    }
}