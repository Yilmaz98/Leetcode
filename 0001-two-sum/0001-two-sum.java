class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        
        // Add the indices for each element
        for(int i=0;i<nums.length;i++) {
            m.put(nums[i], i);
        }
        
        System.out.println(m);
        // Just navigate through the list and see if you have a remaining difference available in the map
        for(int i=0;i<nums.length;i++) {
            if(m.containsKey(target - nums[i]) && m.get(target - nums[i]) != i) {
                return new int[]{i, m.get(target - nums[i])};
            }
        }
        
        return new int[]{0,0};
    }
}