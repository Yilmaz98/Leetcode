class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        
        Map<Integer, Integer> left = new HashMap<>();
        
        Map<Integer, Integer> right = new HashMap<>();
        
        int maxCount = 0;
        for(int i=0;i<nums.length;i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            maxCount = Math.max(count.get(nums[i]),maxCount);
        }
        
        
        for(int i=0;i<nums.length;i++) {
            if(left.containsKey(nums[i]))
                continue;
            left.put(nums[i], i);
        }
        
         for(int i=nums.length -1;i>=0;i--) {
            if(right.containsKey(nums[i]))
                continue;
            right.put(nums[i], i);
        }
        
        int result = Integer.MAX_VALUE;
        
        for(Integer key : count.keySet()) {
            if(maxCount == count.get(key)) {
                result = Math.min(result, Math.abs(right.get(key) - left.get(key)) + 1);
            }
        }
        
        return result;
    }
}