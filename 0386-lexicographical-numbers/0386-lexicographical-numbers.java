class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        backtrack(n, result, 0);
        return result;
    }
    
    public void backtrack(int n, List<Integer> result, int curr) { 
        int start = curr == 0 ? 1 : 0;
        for(int i = start;i<=9;i++) {
            curr = curr * 10 + i;
            if(curr > n) {
                curr = curr / 10;
                return;
            }   
            else {    
                result.add(curr);
                backtrack(n, result, curr);
            }
            curr = curr / 10;
        }
    }
}