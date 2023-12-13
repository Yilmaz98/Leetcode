class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        
        int n = nums.length;
        
        for(int i=0;i<n;i++) {
            m.put(nums[i], i);    
        }
        
        
        
        for(int i=0;i<n;i++) {
            if(m.containsKey(target - nums[i]) && m.get(target - nums[i]) != i) {
                return new int[]{i, m.get(target - nums[i])};
            }
        }
        
        return new int[]{-1,-1};
    }
}