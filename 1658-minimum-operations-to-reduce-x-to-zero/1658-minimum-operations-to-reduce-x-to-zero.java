class Solution {
    public int minOperations(int[] nums, int x) {
         int target = -x;
        for (int num : nums) target += num; 
        //target = 6
        
        if (target == 0) return nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        int res = Integer.MIN_VALUE; 
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            
            // map (0,-1), (1,0), (2,1), (6,2), (8,3), (11,4)
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }      
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }
}