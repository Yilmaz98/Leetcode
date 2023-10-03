class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        
        int result = 0;
        
        for(Integer i : m.keySet()) {
            int count = m.get(i);
            if(count >= 2) {
                result += ((count) * (count - 1)) / 2;
            }
        }
        
        return result;
    }
}