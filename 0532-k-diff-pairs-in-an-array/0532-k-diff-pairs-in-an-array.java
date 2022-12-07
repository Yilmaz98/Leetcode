class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            m.put(nums[i], i);
        }
        
        Set<List<Integer>> used = new HashSet<>();
        for(int i=0;i<nums.length;i++) {
            if(m.containsKey(nums[i] + k) && m.get(nums[i] + k) != i)  {
                used.add(Arrays.asList(nums[i], nums[i] + k));
            }
        }
        
        return used.size();
    }
}