class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), result, new HashSet<>());
        return result;
    }
    
    public void helper(int[] nums, int start, List<Integer> tempList, List<List<Integer>> result, Set<Integer> tempSet) {
        if(tempList.size() == nums.length)
            result.add(new ArrayList<>(tempList));
        
        for(int i=0;i<nums.length;i++) {   
            if(tempSet.contains(nums[i]))
                continue;

            tempSet.add(nums[i]);
            tempList.add(nums[i]);
            
            helper(nums, i+1, tempList, result, tempSet);
            
            tempSet.remove(nums[i]);
            tempList.remove(tempList.size()-1);
        }
    }
}