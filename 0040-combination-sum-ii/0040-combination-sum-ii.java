class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(candidates, target, new ArrayList<>(), result, 0);
            return result;
    }
    
    public void backtrack(int[] candidates, int target, List<Integer> curr, List<List<Integer>> result, int start) {
        if(target < 0)
            return;
        
        if(target == 0) {
            result.add(new ArrayList<>(curr));
            curr = new ArrayList<>();
            return;
        }

        
        for(int i = start;i<candidates.length;i++) {
            if(i != start && candidates[i] == candidates[i-1])
                continue;
            curr.add(candidates[i]);
            backtrack(candidates, target - candidates[i], curr, result, i + 1);
            curr.remove(curr.size() - 1);
        }        
    }
}