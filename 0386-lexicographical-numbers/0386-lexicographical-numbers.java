class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        
        backtrack(n, result, new StringBuilder(), true);
        
        return result;
    }
    
    public void backtrack(int n, List<Integer> result, StringBuilder sb, boolean firstTime) { 
        int start = firstTime ? 1 : 0;
        for(int i = start;i<=9;i++) {
            sb.append(i);
            int val = Integer.parseInt(sb.toString());
        
            if(val > n) {
                sb.deleteCharAt(sb.length() -1);
                return;
            }   
            else {    
                result.add(val);
                backtrack(n, result, sb, false);
            }
            sb.deleteCharAt(sb.length() -1);
        }
    }
}