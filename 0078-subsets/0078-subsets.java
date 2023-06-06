class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums,0, new ArrayList<>(), result);
        
        return result;
    }
    
    public void subsets(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList));
        
        for(int i=start;i<nums.length;i++) {
            tempList.add(nums[i]);
            subsets(nums,i+1,tempList, result);
            tempList.remove(tempList.size() -1);
        }
    }
}