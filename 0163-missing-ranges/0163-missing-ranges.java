class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        
        if(n == 0)
            return Arrays.asList(Arrays.asList(lower, upper));
        
        List<List<Integer>> result = new ArrayList<>();
        
        if(lower < nums[0]) {
            result.add(Arrays.asList(lower, nums[0] - 1));
        }
        
        for(int i = 0;i<n - 1;i++) {
            if(nums[i + 1] - nums[i] <= 1) {
                continue;
            }
            
            result.add(Arrays.asList(nums[i] + 1, nums[i + 1]- 1));
        }
        
        
        if(upper > nums[n - 1]) {
            result.add(Arrays.asList(nums[n - 1] + 1, upper));
        }
        
        return result;
    }
}