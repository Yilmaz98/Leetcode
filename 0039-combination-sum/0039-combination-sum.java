class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        backtrack(candidates, target, new ArrayList<>(), result, 0, 0);
        
        return result;
    }
    
    public void backtrack(int[] candidates, int target, List<Integer> temp, List<List<Integer>> result, int sum, int start)   {
        
        if(sum > target) {
            return;
        }
        
        if(sum == target) {
            result.add(new ArrayList<>(temp));
            temp = new ArrayList<>();
            return;
        }
        
        for(int i=start;i<candidates.length;i++) {
            temp.add(candidates[i]);
            backtrack(candidates, target, temp, result, sum + candidates[i], i);
            temp.remove(temp.size() - 1);
        } 
    }
}