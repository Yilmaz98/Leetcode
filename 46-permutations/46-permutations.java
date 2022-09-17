class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, nums, new ArrayList<>());
        return result;
    }
    
    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> tempList) {
        if(tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            for(int i=0;i<nums.length;i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                dfs(result,nums,tempList);
                tempList.remove(tempList.size()-1);
            }
        }    
    }
}