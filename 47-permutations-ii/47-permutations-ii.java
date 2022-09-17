class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<>(), res, visited);
        return new ArrayList<>(res);
    }
    
    private void helper(int[] nums, List<Integer> tmp, Set<List<Integer>> res, boolean[] visited) {
        if (nums.length == tmp.size()) {
        	res.add(new ArrayList<>(tmp));
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (visited[i]) continue;
            tmp.add(nums[i]);
            visited[i] = true;
            helper(nums, tmp, res, visited);
            visited[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}
