class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer,Integer> m = new HashMap<>();
        
        for(int i=0;i<nums.length;i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        
        int ans[] = new int[2];
        for(Integer i: m.keySet()) {
            ans[0] += m.get(i)/2;
            ans[1] += m.get(i)%2;
        }
        
        return ans;
    }
}