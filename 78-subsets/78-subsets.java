class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(result,0,new ArrayList<>(), nums);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, int start, List<Integer> tempList, int[] nums) {
        result.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            tempList.add(nums[i]);
            backtrack(result, i + 1, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }
}