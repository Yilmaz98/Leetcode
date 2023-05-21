class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        TreeMap<Integer,Integer> m = new TreeMap<>();
        
        for(int num : nums) {
            m.put(num, m.getOrDefault(num,0) + 1);
        }
        
        int prev = Integer.MIN_VALUE;
        int count = 1;
        int ans = 1;
        
        for(Integer v : m.keySet()) {
                if(v - prev == 1) {
                    count++;
                    ans = Math.max(ans, count);
                } else {
                    count = 1;
                }
                prev = v;
        }
        
        return ans;
    }
}